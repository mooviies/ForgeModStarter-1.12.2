package com.mooviies.maplelib.item.tool;

import com.mooviies.maplelib.MapleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class MItemAxe extends ItemAxe {

    private String name;
    private static ArrayList<MItemAxe> items = new ArrayList<>();

    public MItemAxe(String name, ToolMaterial material, float damage, float speedModifier) {
        super(material, damage, speedModifier);
        initialize(name);
    }

    public static void register(IForgeRegistry<Item> registry) {
        for(MItemAxe item : items)
            registry.register(item);
    }

    public static void registerItemModel() {
        for(MItemAxe item : items)
            MapleMod.proxy.registerItemRenderer(item, 0, item.name);
    }

    @Override
    public MItemAxe setCreativeTab(CreativeTabs tab) {
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
