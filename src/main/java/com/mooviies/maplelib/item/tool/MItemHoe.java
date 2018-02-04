package com.mooviies.maplelib.item.tool;

import com.mooviies.maplelib.MapleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class MItemHoe extends ItemHoe {

    private String name;
    private static ArrayList<MItemHoe> items = new ArrayList<>();

    public MItemHoe(String name, ToolMaterial material) {
        super(material);
        initialize(name);
    }

    public static void register(IForgeRegistry<Item> registry) {
        for(MItemHoe item : items)
            registry.register(item);
    }

    public static void registerItemModel() {
        for(MItemHoe item : items)
            MapleMod.proxy.registerItemRenderer(item, 0, item.name);
    }

    @Override
    public MItemHoe setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    private void initialize(String name)
    {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(MapleMod.creativeTab);

        items.add(this);
    }
}
