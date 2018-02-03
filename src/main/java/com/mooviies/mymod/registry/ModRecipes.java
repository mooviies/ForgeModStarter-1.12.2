package com.mooviies.mymod.registry;

import com.mooviies.mymod.registry.ModBlocks;
import com.mooviies.mymod.registry.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
    public static void init() {
        GameRegistry.addSmelting(ModBlocks.oreCopper, new ItemStack(ModItems.ingotCopper), 0.7f);
    }
}
