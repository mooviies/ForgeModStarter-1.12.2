package com.mooviies.mymod.item;

import com.mooviies.mymod.MyMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class MyItem extends Item {

    protected String name;
    private static ArrayList<MyItem> items = new ArrayList<>();

    public MyItem(String name) {
        initialize(name);
    }

    public static void register(IForgeRegistry<Item> registry) {

        for(MyItem item : items)
            registry.register(item);
    }

    public static void registerItemModel() {
        for(MyItem item : items)
            MyMod.proxy.registerItemRenderer(item, 0, item.name);
    }

    @Override
    public MyItem setCreativeTab(CreativeTabs tab) {
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
