package com.mooviies.mymod.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

public class BlockOre extends MyBlock {

    private String oreName;
    private static ArrayList<BlockOre> blockOres = new ArrayList<>();

    public BlockOre(String name, String oreName) {
        super(name, Material.ROCK);
        initialize(3f, 5f, oreName);
    }

    public static void initOreDict() {
        for(BlockOre blockOre : blockOres)
            OreDictionary.registerOre(blockOre.oreName, blockOre);
    }

    public BlockOre(String name, String oreName, float hardness, float resistance) {
        super(name, Material.ROCK);
        initialize(hardness, resistance, oreName);
    }

    @Override
    public BlockOre setCreativeTab(CreativeTabs tab) {
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
