package io.github.gregtechintergalactical.gtcore;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.teamresourceful.resourcefullib.common.networking.base.NetworkDirection;
import io.github.gregtechintergalactical.gtcore.client.BakedModels;
import io.github.gregtechintergalactical.gtcore.data.*;
import io.github.gregtechintergalactical.gtcore.data.client.ScreenFactories;
import io.github.gregtechintergalactical.gtcore.datagen.GTCoreBlockLootProvider;
import io.github.gregtechintergalactical.gtcore.datagen.GTCoreBlockTagProvider;
import io.github.gregtechintergalactical.gtcore.datagen.GTCoreItemTagProvider;
import io.github.gregtechintergalactical.gtcore.datagen.GTCoreLang;
import io.github.gregtechintergalactical.gtcore.loader.crafting.CircuitRecipes;
import io.github.gregtechintergalactical.gtcore.loader.crafting.MachineRecipes;
import io.github.gregtechintergalactical.gtcore.loader.crafting.RubberRecipes;
import io.github.gregtechintergalactical.gtcore.loader.machines.AssemblyLoader;
import io.github.gregtechintergalactical.gtcore.network.MessageCraftingSync;
import io.github.gregtechintergalactical.gtcore.tree.RubberTree;
import io.github.gregtechintergalactical.gtcore.tree.RubberTreeWorldGen;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.AntimatterMod;
import muramasa.antimatter.Ref;
import muramasa.antimatter.datagen.AntimatterDynamics;
import muramasa.antimatter.datagen.builder.AntimatterTagBuilder;
import muramasa.antimatter.datagen.providers.*;
import muramasa.antimatter.event.CraftingEvent;
import muramasa.antimatter.event.MaterialEvent;
import muramasa.antimatter.event.ProvidersEvent;
import muramasa.antimatter.network.AntimatterNetwork;
import muramasa.antimatter.recipe.loader.IRecipeRegistrate;
import muramasa.antimatter.registration.IAntimatterRegistrar;
import muramasa.antimatter.registration.RegistrationEvent;
import muramasa.antimatter.registration.Side;
import muramasa.antimatter.util.AntimatterPlatformUtils;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.BiConsumer;

import static muramasa.antimatter.data.AntimatterMaterialTypes.PLATE;
import static muramasa.antimatter.data.AntimatterMaterialTypes.RING;

public class GTCore extends AntimatterMod {

    public static final Logger LOGGER = LogManager.getLogger(); // Directly reference a log4j logger.
    public static final String ID = "gtcore", NAME = "GT Core";
    public static final ResourceLocation SYNC_ID = new ResourceLocation(GTCore.ID, "crafting_sync");

    @Override
    public void onRegistrarInit() {
        super.onRegistrarInit();
        AntimatterDynamics.clientProvider(ID, () -> new AntimatterBlockStateProvider(ID, NAME + " BlockStates"));
        AntimatterDynamics.clientProvider(ID, () -> new AntimatterItemModelProvider(ID, NAME + " Item Models"));
        AntimatterDynamics.clientProvider(ID, GTCoreLang.en_US::new);
    }

    @Override
    public void onRegistrationEvent(RegistrationEvent event, Side side) {
        switch (event) {
            case DATA_INIT -> {
                SlotTypes.init();
                MenuHandlers.init();
                GTCoreBlocks.init();
                GTCoreItems.init();
                GTCoreMaterials.init();
                RecipeMaps.init();
                if (side.isClient()) RecipeMaps.clientMaps();
                RubberTree.init();
                RubberTreeWorldGen.init();
                AntimatterNetwork.NETWORK.registerPacket(NetworkDirection.CLIENT_TO_SERVER, SYNC_ID, MessageCraftingSync.HANDLER, MessageCraftingSync.class);
            }
            case DATA_READY -> {
                WoodType.register(GTCoreBlocks.RUBBER_WOOD_TYPE);
                GTCoreRemapping.init();
            }
            case CLIENT_DATA_INIT -> {
                BakedModels.init();
                ScreenFactories.init();
            }
        }
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public void onMaterialEvent(MaterialEvent event) {
        event.setMaterial(GTCoreMaterials.RUBBER).asSolid(295, PLATE, RING);
    }

    public static void onCrafting(CraftingEvent event){
        event.addLoader(CircuitRecipes::initRecipes);
        event.addLoader(MachineRecipes::initRecipes);
        event.addLoader(RubberRecipes::addRecipes);
    }

    public static void registerRecipeLoaders(IAntimatterRegistrar registrar, IRecipeRegistrate reg) {
        BiConsumer<String, IRecipeRegistrate.IRecipeLoader> loader = (a, b) -> reg.add(GTCore.ID, a, b);
        loader.accept("assembling", AssemblyLoader::init);
    }

    public static void onProviders(ProvidersEvent ev) {
        final AntimatterBlockTagProvider[] p = new AntimatterBlockTagProvider[1];
        ev.addProvider(ID, () -> {
            p[0] = new GTCoreBlockTagProvider(ID, NAME.concat(" Block Tags"), false);
            return p[0];
        });
        ev.addProvider(ID, () -> new GTCoreItemTagProvider(ID, NAME.concat(" Item Tags"), false, p[0]));

        ev.addProvider(ID, () -> new GTCoreBlockLootProvider(ID, NAME.concat(" Loot generator")));
        ev.addProvider(ID, () -> new AntimatterTagProvider<>(BuiltinRegistries.BIOME, ID, NAME.concat(" Biome Tags"), "worldgen/biome") {
            @Override
            protected void processTags(String domain) {
                AntimatterTagBuilder<Biome> tags = this.tag(TagUtils.getBiomeTag(new ResourceLocation(ID, "is_invalid_rubber"))).addTag(BiomeTags.IS_TAIGA).addTag(BiomeTags.IS_MOUNTAIN).addTag(BiomeTags.IS_OCEAN).addTag(BiomeTags.IS_DEEP_OCEAN).addTag(BiomeTags.IS_NETHER).addTag(TagUtils.getBiomeTag(new ResourceLocation("is_desert"))).addTag(TagUtils.getBiomeTag(new ResourceLocation("is_plains")));
                boolean forge = AntimatterPlatformUtils.isForge();
                String d = forge ? "forge" : "c";
                String end = forge ? "is_end" : "in_the_end";
                tags.addTag(TagUtils.getBiomeTag(new ResourceLocation(d, end)));
                tags.addTag(TagUtils.getBiomeTag(new ResourceLocation(d, forge ? "is_snowy" : "snowy")));
            }
        });
        ev.addProvider(ID, () -> new AntimatterTagProvider<>(BuiltinRegistries.CONFIGURED_FEATURE, ID, NAME.concat(" Configured Feature Tags"), "worldgen/configured_feature") {
            @Override
            protected void processTags(String domain) {
                if (AntimatterAPI.isModLoaded("tfc")){
                    this.tag(TagKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, new ResourceLocation("tfc", "forest_trees"))).add(ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, new ResourceLocation(GTCore.ID, "tree/rubber_entry")));
                }
            }
        });
        ev.addProvider(ID, () -> new AntimatterWorldgenProvider(ID, NAME.concat(" Configured Features"), "configured_feature"){
            @Override
            public void run() {
                if (!AntimatterAPI.isModLoaded("tfc")) return;
                JsonObject object = new JsonObject();
                object.addProperty("type", "tfc:random_tree");
                JsonObject config = new JsonObject();
                JsonArray structures = new JsonArray();
                structures.add("gtcore:rubber_dead/1");
                structures.add("gtcore:rubber_dead/2");
                structures.add("gtcore:rubber_dead/3");
                structures.add("gtcore:rubber_dead/4");
                config.add("structures", structures);
                config.addProperty("radius", 1);
                JsonObject placement = new JsonObject();
                placement.addProperty("width", 1);
                placement.addProperty("height", 9);
                placement.addProperty("allow_submerged", true);
                placement.addProperty("allow_deeply_submerged", false);
                config.add("placement", placement);
                object.add("config", config);
                addJsonObject(new ResourceLocation(ID, "tree/rubber_dead"), object);

                object = new JsonObject();
                object.addProperty("type", "tfc:forest_entry");
                config = new JsonObject();
                config.addProperty("min_rain", 250);
                config.addProperty("max_rain", 400);
                config.addProperty("min_temp", 15.0);
                config.addProperty("max_temp", 40.0);
                JsonArray groundCover = new JsonArray();
                JsonObject block = new JsonObject();
                block.addProperty("block", "gtcore:rubber_twig");
                groundCover.add(block);
                block = new JsonObject();
                block.addProperty("block", "gtcore:rubber_fallen_leaves");
                groundCover.add(block);
                config.add("groundcover", groundCover);
                config.addProperty("normal_tree", "gtcore:rubber_tree_normal");
                config.addProperty("dead_tree", "gtcore:tree/rubber_dead");
                config.addProperty("fallen_log", "gtcore:rubber_log");
                object.add("config", config);
                addJsonObject(new ResourceLocation(ID, "tree/rubber_entry"), object);

            }
        });
    }
}
