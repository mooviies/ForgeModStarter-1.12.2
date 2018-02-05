package com.mooviies.maplelib;

import net.minecraft.creativetab.CreativeTabs;

class MapleLibraryDescriptor extends MapleModDescriptor {

    @Override
    public String getGroupID() {
        return MapleMod.GROUPID;
    }

    @Override
    public String getModID() {
        return MapleMod.MODID;
    }

    @Override
    public String getPackage() {
        return MapleMod.PACKAGE;
    }

    @Override
    public String getName() {
        return MapleMod.NAME;
    }

    @Override
    public String getVersion() {
        return MapleMod.VERSION;
    }

    @Override
    public CreativeTabs getCreativeTab() {
        return MapleMod.CREATIVE_TAB;
    }
}
