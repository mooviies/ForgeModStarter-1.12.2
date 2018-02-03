package com.mooviies.mymod.item.tool;

import com.mooviies.mymod.MyMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class MyItemHoe extends ItemHoe {

    private String name;
    private static ArrayList<MyItemHoe> items = new ArrayList<>();

    public MyItemHoe(String name, ToolMaterial material) {
        super(material);
        initialize(name);
    }

    public static void register(IForgeRegistry<Item> registry) {
        for(MyItemHoe item : items)
            registry.register(item);
    }

    public static void registerItemModel() {
        for(MyItemHoe item : items)
            MyMod.proxy.registerItemRenderer(item, 0, item.name);
    }

    @Override
    public MyItemHoe setCreativeTab(CreativeTabs tab) {
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
