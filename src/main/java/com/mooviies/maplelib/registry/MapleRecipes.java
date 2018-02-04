package com.mooviies.maplelib.registry;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MapleRecipes {
    public static void init() {
        GameRegistry.addSmelting(MapleBlocks.oreCopper, new ItemStack(MapleItems.ingotCopper), 0.7f);
    }
}
