package com.mooviies.mymod.registry;

import com.mooviies.mymod.item.ItemOre;
import com.mooviies.mymod.item.MyItem;
import com.mooviies.mymod.item.MyItemFood;
import com.mooviies.mymod.item.MyItemSeeds;
import com.mooviies.mymod.item.armor.MyItemArmor;
import com.mooviies.mymod.item.tool.*;
import com.mooviies.mymod.material.ModMaterials;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static ItemOre ingotCopper = new ItemOre("ingot_copper", "ingotCopper");

    public static MyItemSeeds cornSeed = new MyItemSeeds("corn_seed", () -> ModBlocks.cropCorn, Blocks.FARMLAND);
    public static MyItemFood corn = new MyItemFood("corn", "cropCorn", 3, 0.6f, false);

    public static MyItemAxe copperAxe = new MyItemAxe("copper_axe", ModMaterials.copperToolMaterial, 9.0f, -3.1f);
    public static MyItemHoe copperHoe = new MyItemHoe("copper_hoe", ModMaterials.copperToolMaterial);
    public static MyItemPickaxe copperPickaxe = new MyItemPickaxe("copper_pickaxe", ModMaterials.copperToolMaterial);
    public static MyItemShovel copperShovel = new MyItemShovel("copper_shovel", ModMaterials.copperToolMaterial);
    public static MyItemSword copperSword = new MyItemSword("copper_sword", ModMaterials.copperToolMaterial);

    public static MyItemArmor copperHelmet = new MyItemArmor("copper_helmet", ModMaterials.copperArmorMaterial, EntityEquipmentSlot.HEAD);
    public static MyItemArmor copperChestplate  = new MyItemArmor("copper_chestplate", ModMaterials.copperArmorMaterial, EntityEquipmentSlot.CHEST);
    public static MyItemArmor copperLeggings   = new MyItemArmor("copper_leggings", ModMaterials.copperArmorMaterial, EntityEquipmentSlot.LEGS);
    public static MyItemArmor copperBoots  = new MyItemArmor("copper_boots", ModMaterials.copperArmorMaterial, EntityEquipmentSlot.FEET);

    public static void init() {
        ItemOre.initOreDict();
        MyItemFood.initOreDict();
    }

    public static void register(IForgeRegistry<Item> registry) {
        MyItem.register(registry);
        MyItemFood.register(registry);
        MyItemSeeds.register(registry);
        MyItemAxe.register(registry);
        MyItemHoe.register(registry);
        MyItemPickaxe.register(registry);
        MyItemShovel.register(registry);
        MyItemSword.register(registry);
        MyItemArmor.register(registry);
    }

    public static void registerModels() {
        MyItem.registerItemModel();
        MyItemFood.registerItemModel();
        MyItemSeeds.registerItemModel();
        MyItemAxe.registerItemModel();
        MyItemHoe.registerItemModel();
        MyItemPickaxe.registerItemModel();
        MyItemShovel.registerItemModel();
        MyItemSword.registerItemModel();
        MyItemArmor.registerItemModel();
    }
}
