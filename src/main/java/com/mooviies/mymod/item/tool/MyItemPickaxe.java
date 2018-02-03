package com.mooviies.mymod.item.tool;

import com.mooviies.mymod.MyMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class MyItemPickaxe extends ItemPickaxe {

    private String name;
    private static ArrayList<MyItemPickaxe> items = new ArrayList<>();

    public MyItemPickaxe(String name, ToolMaterial material) {
        super(material);
        initialize(name);
    }

    public static void register(IForgeRegistry<Item> registry) {
        for(MyItemPickaxe item : items)
            registry.register(item);
    }

    public static void registerItemModel() {
        for(MyItemPickaxe item : items)
            MyMod.proxy.registerItemRenderer(item, 0, item.name);
    }

    @Override
    public MyItemPickaxe setCreativeTab(CreativeTabs tab) {
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
