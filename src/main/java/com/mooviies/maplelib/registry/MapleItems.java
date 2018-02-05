package com.mooviies.maplelib.registry;

import com.mooviies.maplelib.item.MItemOre;
import com.mooviies.maplelib.item.MItem;
import com.mooviies.maplelib.item.MItemFood;
import com.mooviies.maplelib.item.MItemSeeds;
import com.mooviies.maplelib.item.armor.MItemArmor;
import com.mooviies.maplelib.item.tool.*;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class MapleItems extends MapleRegistry {

    public static void init() {
        MItemOre.initOreDict();
        MItemFood.initOreDict();
    }

    public static void register(IForgeRegistry<Item> registry) {
        MItem.register(registry);
        MItemFood.register(registry);
        MItemSeeds.register(registry);
        MItemAxe.register(registry);
        MItemHoe.register(registry);
        MItemPickaxe.register(registry);
        MItemShovel.register(registry);
        MItemSword.register(registry);
        MItemArmor.register(registry);
    }

    public static void registerModels() {
        MItem.registerItemModel();
        MItemFood.registerItemModel();
        MItemSeeds.registerItemModel();
        MItemAxe.registerItemModel();
        MItemHoe.registerItemModel();
        MItemPickaxe.registerItemModel();
        MItemShovel.registerItemModel();
        MItemSword.registerItemModel();
        MItemArmor.registerItemModel();
    }
}
