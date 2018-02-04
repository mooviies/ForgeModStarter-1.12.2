package com.mooviies.maplelib.block;

import com.mooviies.maplelib.MapleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class MBlock extends Block {

    protected String name;
    private static ArrayList<MBlock> blocks = new ArrayList<>();

    public MBlock(String name, Material material) {
        super(material);
        initialize(name);
    }

    public static void register(IForgeRegistry<Block> registry) {

        for(MBlock block : blocks)
            registry.register(block);
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {

        for(MBlock block : blocks)
            registry.register(block.createItemBlock());
    }

    public static void registerItemModels() {

        for(MBlock block : blocks)
            MapleMod.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, block.name);
    }

    @Override
    public MBlock setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    private Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    private void initialize(String name)
    {
        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(MapleMod.creativeTab);

        blocks.add(this);
    }
}
