package com.mooviies.mymod.item.tool;

import com.mooviies.mymod.MyMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class MyItemShovel extends ItemSpade {

    private String name;
    private static ArrayList<MyItemShovel> items = new ArrayList<>();

    public MyItemShovel(String name, ToolMaterial material) {
        super(material);
        initialize(name);
    }

    public static void register(IForgeRegistry<Item> registry) {
        for(MyItemShovel item : items)
            registry.register(item);
    }

    public static void registerItemModel() {
        for(MyItemShovel item : items)
            MyMod.proxy.registerItemRenderer(item, 0, item.name);
    }

    @Override
    public MyItemShovel setCreativeTab(CreativeTabs tab) {
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
