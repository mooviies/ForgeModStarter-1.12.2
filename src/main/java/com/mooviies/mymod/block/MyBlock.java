package com.mooviies.mymod.block;

import com.mooviies.mymod.MyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class MyBlock extends Block {

    protected String name;
    private static ArrayList<MyBlock> blocks = new ArrayList<>();

    public MyBlock(String name, Material material) {
        super(material);
        initialize(name);
    }

    public static void register(IForgeRegistry<Block> registry) {

        for(MyBlock block : blocks)
            registry.register(block);
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {

        for(MyBlock block : blocks)
            registry.register(block.createItemBlock());
    }

    public static void registerItemModels() {

        for(MyBlock block : blocks)
            MyMod.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, block.name);
    }

    @Override
    public MyBlock setCreativeTab(CreativeTabs tab) {
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
        setCreativeTab(MyMod.creativeTab);

        blocks.add(this);
    }
}
