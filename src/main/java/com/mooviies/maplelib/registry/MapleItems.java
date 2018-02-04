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

public class MapleItems {

    public static MItemOre ingotCopper = new MItemOre("ingot_copper", "ingotCopper");

    public static MItemSeeds cornSeed = new MItemSeeds("corn_seed", () -> MapleBlocks.cropCorn, Blocks.FARMLAND);
    public static MItemFood corn = new MItemFood("corn", "cropCorn", 3, 0.6f, false);

    public static MItemAxe copperAxe = new MItemAxe("copper_axe", MapleMaterials.copperToolMaterial, 9.0f, -3.1f);
    public static MItemHoe copperHoe = new MItemHoe("copper_hoe", MapleMaterials.copperToolMaterial);
    public static MItemPickaxe copperPickaxe = new MItemPickaxe("copper_pickaxe", MapleMaterials.copperToolMaterial);
    public static MItemShovel copperShovel = new MItemShovel("copper_shovel", MapleMaterials.copperToolMaterial);
    public static MItemSword copperSword = new MItemSword("copper_sword", MapleMaterials.copperToolMaterial);

    public static MItemArmor copperHelmet = new MItemArmor("copper_helmet", MapleMaterials.copperArmorMaterial, EntityEquipmentSlot.HEAD);
    public static MItemArmor copperChestplate  = new MItemArmor("copper_chestplate", MapleMaterials.copperArmorMaterial, EntityEquipmentSlot.CHEST);
    public static MItemArmor copperLeggings   = new MItemArmor("copper_leggings", MapleMaterials.copperArmorMaterial, EntityEquipmentSlot.LEGS);
    public static MItemArmor copperBoots  = new MItemArmor("copper_boots", MapleMaterials.copperArmorMaterial, EntityEquipmentSlot.FEET);

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
