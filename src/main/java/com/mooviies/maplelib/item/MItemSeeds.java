package com.mooviies.maplelib.item;

import com.mooviies.maplelib.MapleMod;
import com.mooviies.maplelib.MapleModDescriptor;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class MItemSeeds extends ItemSeeds {

    protected String name;

    protected EnumPlantType type;
    protected Block crops;
    protected ArrayList<Block> soils = new ArrayList<>();
    protected MapleModDescriptor modDescriptor;

    private BlockCropsSetter blockCropsSetter;
    private static ArrayList<MItemSeeds> items = new ArrayList<>();

    public MItemSeeds(MapleModDescriptor modDescriptor, String name, BlockCropsSetter blockCropsSetter, Block ... soils) {
        super(null, null);
        initialize(modDescriptor, name, blockCropsSetter, EnumPlantType.Crop, soils);
    }

    public MItemSeeds(MapleModDescriptor modDescriptor, String name, BlockCropsSetter blockCropsSetter, EnumPlantType type, Block ... soils) {
        super(null, null);
        initialize(modDescriptor, name, blockCropsSetter, type, soils);
    }

    public static void register(IForgeRegistry<Item> registry)
    {
        for(MItemSeeds item : items)
        {
            item.crops = item.blockCropsSetter.onRegister();
            registry.register(item);
        }
    }

    public static void registerItemModel() {
        for(MItemSeeds item : items)
            MapleMod.proxy.registerItemRenderer(item.modDescriptor, item, 0, item.name);
    }

    @Override
    public MItemSeeds setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = player.getHeldItem(hand);
        net.minecraft.block.state.IBlockState state = worldIn.getBlockState(pos);
        if (facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, itemstack) && soils.contains(state.getBlock()) && worldIn.isAirBlock(pos.up()))
        {
            worldIn.setBlockState(pos.up(), this.crops.getDefaultState());

            if (player instanceof EntityPlayerMP)
            {
                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos.up(), itemstack);
            }

            itemstack.shrink(1);
            return EnumActionResult.SUCCESS;
        }
        else
        {
            return EnumActionResult.FAIL;
        }
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return type;
    }

    @Override
    public net.minecraft.block.state.IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return this.crops.getDefaultState();
    }

    private void initialize(MapleModDescriptor modDescriptor, String name, BlockCropsSetter blockCropsSetter, EnumPlantType type, Block ... soils)
    {
        this.name = name;
        this.type = type;
        this.blockCropsSetter = blockCropsSetter;

        for(Block soil : soils)
        {
            if(!this.soils.contains(soil))
                this.soils.add(soil);
        }

        setUnlocalizedName(name);
        setRegistryName(name);

        items.add(this);

        this.modDescriptor = modDescriptor;
        setCreativeTab(modDescriptor.getCreativeTab());
    }

    public interface BlockCropsSetter{
        Block onRegister();
    }
}
