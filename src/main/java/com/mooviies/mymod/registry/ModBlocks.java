package com.mooviies.mymod.registry;

import com.mooviies.mymod.block.*;
import com.mooviies.mymod.registry.ModItems;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

    public static BlockOre oreCopper = new BlockOre("ore_copper", "oreCopper");
    public static MyBlockCrops cropCorn = new MyBlockCrops("crop_corn", ModItems.cornSeed, ModItems.corn);
    public static BlockPedestal pedestal = new BlockPedestal();
    public static BlockCounter counter = new BlockCounter();

    public static void init() {
        BlockOre.initOreDict();
    }

    public static void register(IForgeRegistry<net.minecraft.block.Block> registry) {
        MyBlock.register(registry);
        MyBlockCrops.register(registry);
        BlockTileEntity.registerTileEntity();
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        MyBlock.registerItemBlocks(registry);
    }

    public static void registerItemModels() {
        MyBlock.registerItemModels();
    }
}
