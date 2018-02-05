package com.mooviies.maplelib.registry;

import com.mooviies.maplelib.block.*;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class MapleBlocks extends MapleRegistry {

    public static void init() {
        MBlockOre.initOreDict();
    }

    public static void register(IForgeRegistry<net.minecraft.block.Block> registry) {
        MBlock.register(registry);
        MBlockCrops.register(registry);
        MBlockTileEntity.registerTileEntity();
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        MBlock.registerItemBlocks(registry);
    }

    public static void registerItemModels() {
        MBlock.registerItemModels();
    }
}
