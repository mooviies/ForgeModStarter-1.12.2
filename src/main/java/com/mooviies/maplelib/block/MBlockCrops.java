package com.mooviies.maplelib.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class MBlockCrops extends BlockCrops {

    protected String name;
    protected ItemSeeds seeds;
    protected Item crop;
    private static ArrayList<MBlockCrops> blocks = new ArrayList<>();

    public MBlockCrops(String name, ItemSeeds seeds, Item crop) {
        initialize(name, seeds, crop);
    }

    public static void register(IForgeRegistry<Block> registry) {

        for(MBlockCrops block : blocks)
            registry.register(block);
    }

    @Override
    protected Item getSeed() {
        return seeds;
    }

    @Override
    protected Item getCrop() {
        return crop;
    }

    private void initialize(String name, ItemSeeds seeds, Item crop)
    {
        this.name = name;
        this.seeds = seeds;
        this.crop = crop;

        setUnlocalizedName(name);
        setRegistryName(name);

        blocks.add(this);
    }
}
