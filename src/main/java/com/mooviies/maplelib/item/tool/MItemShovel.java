package com.mooviies.maplelib.item.tool;

import com.mooviies.maplelib.MapleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class MItemShovel extends ItemSpade {

    private String name;
    private static ArrayList<MItemShovel> items = new ArrayList<>();

    public MItemShovel(String name, ToolMaterial material) {
        super(material);
        initialize(name);
    }

    public static void register(IForgeRegistry<Item> registry) {
        for(MItemShovel item : items)
            registry.register(item);
    }

    public static void registerItemModel() {
        for(MItemShovel item : items)
            MapleMod.proxy.registerItemRenderer(item, 0, item.name);
    }

    @Override
    public MItemShovel setCreativeTab(CreativeTabs tab) {
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
