package com.mooviies.maplelib.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

public class MItemOre extends MItem {

    private String oreName;
    private static ArrayList<MItemOre> items = new ArrayList<>();

    public MItemOre(String name, String oreName) {
        super(name);
        this.oreName = oreName;
        items.add(this);
    }

    public static void initOreDict() {
        for(MItemOre item : items)
            OreDictionary.registerOre(item.oreName, item);
    }

    @Override
    public MItemOre setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
