package io.github.gregtechintergalactical.gtutility.machine;

import earth.terrarium.botarium.common.fluid.base.FluidHolder;
import earth.terrarium.botarium.common.fluid.utils.FluidHooks;
import io.github.gregtechintergalactical.gtutility.GTUtility;
import io.github.gregtechintergalactical.gtutility.blockentity.BlockEntityDrum;
import io.github.gregtechintergalactical.gtutility.item.ItemBlockDrum;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.texture.Texture;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockBehaviour;
import tesseract.FluidPlatformUtils;

import static muramasa.antimatter.Data.WRENCH_MATERIAL;

public class DrumMachine extends MaterialMachine{
    public final int maxCapacity;
    private boolean acidProof = false;
    public DrumMachine(String domain, Material material, int maxCapacity) {
        super(domain, material.getId() + "_drum", material);
        AntimatterAPI.register(DrumMachine.class, this);
        this.maxCapacity = maxCapacity;
        setTiers(Tier.NONE);
        this.setTile(((materialMachine, blockPos, blockState) -> new BlockEntityDrum(this, blockPos, blockState)));
        setBlock((type, tier) -> new BlockMachineMaterial(type, tier, BlockBehaviour.Properties.of(WRENCH_MATERIAL).strength(1.0f, 10.0f)));
        setItemBlock(ItemBlockDrum::new);
        setTooltipInfo((machine, stack, world, tooltip, flag) -> {
            tooltip.add(new TranslatableComponent("machine.drum.capacity", maxCapacity));
            if (acidProof){
                tooltip.add(new TranslatableComponent("antimatter.tooltip.acid_proof"));
            }
            CompoundTag nbt = stack.getTag();
            if (nbt != null && (nbt.contains("Fluid") || nbt.contains("Outputs"))){
                FluidHolder fluid = nbt.contains("Fluid") ? FluidHooks.fluidFromCompound(nbt.getCompound("Fluid")) : FluidHooks.safeGetItemFluidManager(stack).map(fi -> fi.getFluidInTank(0)).orElse(FluidHooks.emptyFluid());
                if (!fluid.isEmpty()){
                    tooltip.add(new TranslatableComponent("machine.drum.fluid", fluid.getFluidAmount(), FluidPlatformUtils.getFluidDisplayName(fluid)));
                }
                if (nbt.contains("Outputs")){
                    tooltip.add(new TranslatableComponent("machine.drum.output"));
                }
            }
        });
        baseTexture((m, t) -> new Texture[] {
                new Texture(GTUtility.ID, "block/machine/base/drum/bottom"),
                new Texture(GTUtility.ID, "block/machine/base/drum/top"),
                new Texture(GTUtility.ID, "block/machine/base/drum/side"),
                new Texture(GTUtility.ID, "block/machine/base/drum/side"),
                new Texture(GTUtility.ID, "block/machine/base/drum/side"),
                new Texture(GTUtility.ID, "block/machine/base/drum/side"),
        });
        overlayTexture((type, state, tier) -> new Texture[] {
                new Texture(GTUtility.ID, "block/machine/overlay/drum/bottom"),
                new Texture(GTUtility.ID, "block/machine/overlay/drum/top"),
                new Texture(GTUtility.ID, "block/machine/overlay/drum/side"),
                new Texture(GTUtility.ID, "block/machine/overlay/drum/side"),
                new Texture(GTUtility.ID, "block/machine/overlay/drum/side"),
                new Texture(GTUtility.ID, "block/machine/overlay/drum/side"),
        });
    }

    public DrumMachine acidProof(){
        this.acidProof = true;
        return this;
    }

    public boolean isAcidProof() {
        return acidProof;
    }
}
