package com.mooviies.mymod.item.armor;

import com.mooviies.mymod.MyMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class MyItemArmor extends ItemArmor {

    private String name;
    private static ArrayList<MyItemArmor> items = new ArrayList<>();

    public MyItemArmor(String name, ArmorMaterial material, EntityEquipmentSlot slot) {
        super(material, 0, slot);
        initialize(name);
    }

    public static void register(IForgeRegistry<Item> registry) {

        for(MyItemArmor item : items)
            registry.register(item);
    }

    public static void registerItemModel() {
        for(MyItemArmor item : items)
            MyMod.proxy.registerItemRenderer(item, 0, item.name);
    }

    @Override
    public MyItemArmor setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    private void initialize(String name)
    {
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
        setCreativeTab(MyMod.creativeTab);

        items.add(this);
    }
}
