package com.mooviies.maplelib;

import net.minecraft.creativetab.CreativeTabs;

public abstract class MapleModDescriptor {
    public abstract String getGroupID();
    public abstract String getModID();
    public abstract String getPackage();
    public abstract String getName();
    public abstract String getVersion();
    public abstract CreativeTabs getCreativeTab();
}
