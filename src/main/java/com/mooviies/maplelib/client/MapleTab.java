package com.mooviies.maplelib.client;

import com.mooviies.maplelib.MapleModDescriptor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MapleTab extends CreativeTabs {

    private MapleTabIconGetter tabIconGetter;

    public MapleTab(MapleModDescriptor modDescriptor, MapleTabIconGetter tabIconGetter) {
        super(modDescriptor.getModID());
        this.tabIconGetter = tabIconGetter;
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(tabIconGetter.get());
    }

    public interface MapleTabIconGetter {
        Item get();
    }
}
