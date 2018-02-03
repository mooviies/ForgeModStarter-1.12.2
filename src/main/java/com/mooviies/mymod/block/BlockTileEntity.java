package com.mooviies.mymod.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nullable;
import java.util.ArrayList;

public abstract class BlockTileEntity<TE extends TileEntity> extends MyBlock {

    private static ArrayList<BlockTileEntity> blocks = new ArrayList<>();

    public BlockTileEntity(String name, Material material) {
        super(name, material);
        blocks.add(this);
    }

    public static void registerTileEntity() {
        for(BlockTileEntity block : blocks)
            GameRegistry.registerTileEntity(block.getTileEntityClass(), block.getRegistryName().toString());
    }

    public abstract Class<TE> getTileEntityClass();

    public TE getTileEntity(IBlockAccess world, BlockPos pos) {
        return (TE)world.getTileEntity(pos);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public abstract TE createTileEntity(World world, IBlockState state);
}
