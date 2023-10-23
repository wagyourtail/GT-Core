package io.github.gregtechintergalactical.gtcore.data;

import io.github.gregtechintergalactical.gtcore.GTCore;
import muramasa.antimatter.gui.GuiData;
import muramasa.antimatter.gui.slot.ISlotProvider;

import static muramasa.antimatter.gui.SlotType.*;
import static muramasa.antimatter.gui.SlotType.FL_OUT;

public class Guis {
    public static GuiData MULTI_DISPLAY = new GuiData(GTCore.ID, "multi_display").setSlots(ISlotProvider.DEFAULT()
            .add(IT_IN, 17, 16).add(IT_IN, 35, 16).add(IT_IN, 53, 16).add(IT_IN, 17, 34).add(IT_IN, 35, 34)
            .add(IT_IN, 53, 34).add(IT_OUT, 107, 16).add(IT_OUT, 125, 16).add(IT_OUT, 143, 16).add(IT_OUT, 107, 34)
            .add(IT_OUT, 125, 34).add(IT_OUT, 143, 34).add(FL_IN, 17, 63).add(FL_IN, 35, 63).add(FL_IN, 53, 63)
            .add(FL_OUT, 107, 63).add(FL_OUT, 125, 63).add(FL_OUT, 143, 63));

    public static GuiData MULTI_DISPLAY_FLUID = new GuiData(GTCore.ID, "multi_display_fluid").setSlots(ISlotProvider.DEFAULT()
            .add(FL_IN, 17, 63).add(FL_IN, 35, 63).add(FL_IN, 53, 63)
            .add(FL_OUT, 107, 7).add(FL_OUT, 125, 7).add(FL_OUT, 143, 7)
            .add(FL_OUT, 107, 25).add(FL_OUT, 125, 25).add(FL_OUT, 143, 25)
            .add(FL_OUT, 107, 43).add(FL_OUT, 125, 43).add(FL_OUT, 143, 43)
            .add(FL_OUT, 107, 61).add(FL_OUT, 125, 61).add(FL_OUT, 143, 61));

    public static void init(){
        GTCoreBlocks.WOOD_ITEM_BARREL.add(DISPLAY, 53, 34).add(SlotTypes.UNLIMITED, 71, 34);
    }
}
