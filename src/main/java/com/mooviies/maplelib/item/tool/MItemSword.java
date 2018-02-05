package com.mooviies.maplelib.item.tool;

import com.mooviies.maplelib.MapleMod;
import com.mooviies.maplelib.MapleModDescriptor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class MItemSword extends ItemSword {

    private String name;
    protected MapleModDescriptor modDescriptor;
    private static ArrayList<MItemSword> items = new ArrayList<>();

    public MItemSword(MapleModDescriptor modDescriptor, String name, ToolMaterial material) {
        super(material);
        initialize(modDescriptor, name);
    }

    public static void register(IForgeRegistry<Item> registry) {
        for(MItemSword item : items)
            registry.register(item);
    }

    public static void registerItemModel() {
        for(MItemSword item : items)
            MapleMod.proxy.registerItemRenderer(item.modDescriptor, item, 0, item.name);
    }

    @Override
    public MItemSword setCreativeTab(CreativeTabs tab) {
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
