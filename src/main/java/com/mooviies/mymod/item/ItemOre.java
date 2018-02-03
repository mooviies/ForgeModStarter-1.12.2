package com.mooviies.mymod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

public class ItemOre extends MyItem {

    private String oreName;
    private static ArrayList<ItemOre> items = new ArrayList<>();

    public ItemOre(String name, String oreName) {
        super(name);
        this.oreName = oreName;
        items.add(this);
    }

    public static void initOreDict() {
        for(ItemOre item : items)
            OreDictionary.registerOre(item.oreName, item);
    }

    @Override
    public ItemOre setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
