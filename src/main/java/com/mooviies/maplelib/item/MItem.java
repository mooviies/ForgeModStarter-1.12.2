package com.mooviies.maplelib.item;

import com.mooviies.maplelib.MapleMod;
import com.mooviies.maplelib.MapleModDescriptor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class MItem extends Item {

    protected String name;
    protected MapleModDescriptor modDescriptor;
    private static ArrayList<MItem> items = new ArrayList<>();

    public MItem(MapleModDescriptor modDescriptor, String name) {
        initialize(modDescriptor, name);
    }

    public static void register(IForgeRegistry<Item> registry) {

        for(MItem item : items)
            registry.register(item);
    }

    public static void registerItemModel() {
        for(MItem item : items)
            MapleMod.proxy.registerItemRenderer(item.modDescriptor, item, 0, item.name);
    }

    @Override
    public MItem setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    private void initialize(MapleModDescriptor modDescriptor, String name)
    {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        items.add(this);

        this.modDescriptor = modDescriptor;
        setCreativeTab(modDescriptor.getCreativeTab());
    }
}
