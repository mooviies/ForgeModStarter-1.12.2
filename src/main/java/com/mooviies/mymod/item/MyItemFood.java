package com.mooviies.mymod.item;

import com.mooviies.mymod.MyMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class MyItemFood extends ItemFood {

    protected String name;
    private String oreName;
    private static ArrayList<MyItemFood> items = new ArrayList<>();

    public MyItemFood(String name, String oreName, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        initialize(name, oreName);
    }

    public static void register(IForgeRegistry<Item> registry) {
        for(MyItemFood item : items)
            registry.register(item);
    }

    public static void registerItemModel() {
        for(MyItemFood item : items)
            MyMod.proxy.registerItemRenderer(item, 0, item.name);
    }

    public static void initOreDict() {
        for(MyItemFood item : items)
            OreDictionary.registerOre(item.oreName, item);
    }

    @Override
    public MyItemFood setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    private void initialize(String name, String oreName)
    {
        this.name = name;
        this.oreName = oreName;

        setUnlocalizedName(name);
        setRegistryName(name);

        items.add(this);
    }
}
