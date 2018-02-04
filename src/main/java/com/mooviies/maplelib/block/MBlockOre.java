package com.mooviies.maplelib.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

public class MBlockOre extends MBlock {

    private String oreName;
    private static ArrayList<MBlockOre> blockOres = new ArrayList<>();

    public MBlockOre(String name, String oreName) {
        super(name, Material.ROCK);
        initialize(3f, 5f, oreName);
    }

    public static void initOreDict() {
        for(MBlockOre blockOre : blockOres)
            OreDictionary.registerOre(blockOre.oreName, blockOre);
    }

    public MBlockOre(String name, String oreName, float hardness, float resistance) {
        super(name, Material.ROCK);
        initialize(hardness, resistance, oreName);
    }

    @Override
    public MBlockOre setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    private void initialize(float hardness, float resistance, String oreName)
    {
        setHardness(hardness);
        setResistance(resistance);
        this.oreName = oreName;
        blockOres.add(this);
    }
}
