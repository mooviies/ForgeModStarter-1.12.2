package com.mooviies.mymod.client;

import com.mooviies.mymod.MyMod;
import com.mooviies.mymod.registry.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MyModTab extends CreativeTabs {
    public MyModTab() {
        super(MyMod.MODID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.ingotCopper);
    }
}
