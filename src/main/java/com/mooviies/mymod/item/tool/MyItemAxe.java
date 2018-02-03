package com.mooviies.mymod.item.tool;

import com.mooviies.mymod.MyMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class MyItemAxe extends ItemAxe {

    private String name;
    private static ArrayList<MyItemAxe> items = new ArrayList<>();

    public MyItemAxe(String name, ToolMaterial material, float damage, float speedModifier) {
        super(material, damage, speedModifier);
        initialize(name);
    }

    public static void register(IForgeRegistry<Item> registry) {
        for(MyItemAxe item : items)
            registry.register(item);
    }

    public static void registerItemModel() {
        for(MyItemAxe item : items)
            MyMod.proxy.registerItemRenderer(item, 0, item.name);
    }

    @Override
    public MyItemAxe setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    private void initialize(String name)
    {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(MyMod.creativeTab);

        items.add(this);
    }
}
