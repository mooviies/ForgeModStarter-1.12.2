package com.mooviies.maplelib.block;

import com.mooviies.maplelib.MapleModDescriptor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nullable;
import java.util.ArrayList;

public abstract class MBlockTileEntity<TE extends TileEntity> extends MBlock {

    private static ArrayList<MBlockTileEntity> blocks = new ArrayList<>();

    public MBlockTileEntity(MapleModDescriptor modDescriptor, String name, Material material) {
        super(modDescriptor, name, material);
        blocks.add(this);
    }

    public static void registerTileEntity() {
        for(MBlockTileEntity block : blocks)
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
