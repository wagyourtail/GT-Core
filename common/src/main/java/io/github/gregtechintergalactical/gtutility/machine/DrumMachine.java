package io.github.gregtechintergalactical.gtutility.machine;

import io.github.gregtechintergalactical.gtutility.GTUtility;
import muramasa.antimatter.Ref;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.texture.Texture;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fluids.FluidStack;

import static muramasa.antimatter.Data.WRENCH_MATERIAL;

public class DrumMachine extends MaterialMachine{
    public final int maxCapacity;
    public DrumMachine(String domain, String id, Material material, int maxCapacity) {
        super(domain, id, material);
        this.maxCapacity = maxCapacity;
        setTiers(Tier.NONE);
        this.setTile(((materialMachine, blockPos, blockState) -> new BlockEntityDrum(this, blockPos, blockState)));
        setBlock((type, tier) -> new BlockMachineMaterial(type, tier, BlockBehaviour.Properties.of(WRENCH_MATERIAL).strength(1.0f, 10.0f)));
        setTooltipInfo((stack, world, tooltip, flag) -> {
            CompoundTag nbt = stack.getTag();
            if (nbt != null && (nbt.contains("Fluid") || nbt.contains("Outputs"))){
                FluidStack fluid = nbt.contains("Fluid") ? FluidStack.loadFluidStackFromNBT(nbt.getCompound("Fluid")) : FluidStack.EMPTY;
                if (fluid != null && !fluid.isEmpty()){
                    tooltip.add(new TranslatableComponent("machine.drum.fluid", fluid.getAmount(), fluid.getDisplayName()));
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
}
