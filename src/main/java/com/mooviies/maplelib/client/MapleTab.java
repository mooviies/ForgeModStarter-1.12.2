package com.mooviies.maplelib.client;

import com.mooviies.maplelib.MapleMod;
import com.mooviies.maplelib.registry.MapleItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MapleTab extends CreativeTabs {
    public MapleTab() {
        super(MapleMod.MODID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(MapleItems.ingotCopper);
    }
}
