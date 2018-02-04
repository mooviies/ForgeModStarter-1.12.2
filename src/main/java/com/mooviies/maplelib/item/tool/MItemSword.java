package com.mooviies.maplelib.item.tool;

import com.mooviies.maplelib.MapleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class MItemSword extends ItemSword {

    private String name;
    private static ArrayList<MItemSword> items = new ArrayList<>();

    public MItemSword(String name, ToolMaterial material) {
        super(material);
        initialize(name);
    }

    public static void register(IForgeRegistry<Item> registry) {
        for(MItemSword item : items)
            registry.register(item);
    }

    public static void registerItemModel() {
        for(MItemSword item : items)
            MapleMod.proxy.registerItemRenderer(item, 0, item.name);
    }

    @Override
    public MItemSword setCreativeTab(CreativeTabs tab) {
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
