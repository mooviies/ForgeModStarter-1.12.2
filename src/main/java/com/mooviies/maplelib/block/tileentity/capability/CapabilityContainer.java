package com.mooviies.maplelib.block.tileentity.capability;

import com.mooviies.maplelib.MapleMod;
import com.mooviies.maplelib.block.tileentity.MTileEntity;
import com.mooviies.maplelib.network.PacketRequestUpdateTileEntity;
import com.mooviies.maplelib.network.PacketUpdateCapability;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import javax.annotation.Nullable;

public abstract class CapabilityContainer {

    private boolean updateNetwork;
    private MTileEntity tileEntity;

    public abstract void setValues(CapabilityContainer container);

    public abstract NBTTagCompound writeToNBT(NBTTagCompound compound);
    public abstract void readFromNBT(NBTTagCompound compound);
    public abstract void toBytes(ByteBuf buf);
    public abstract CapabilityContainer fromBytes(ByteBuf buf);

    @Nullable
    public abstract <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing);
    public abstract boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing);

    public abstract Capability getCapabilityType();
    public abstract <T> T getCapability();

    public CapabilityContainer(MTileEntity tileEntity, boolean updateNetwork)
    {
        this.tileEntity = tileEntity;
        this.updateNetwork = updateNetwork;
    }

    protected void onContentsChanged()
    {
        if(!updateNetwork)
            return;

        World world = tileEntity.getWorld();

        if (!world.isRemote) {
            BlockPos pos = tileEntity.getPos();
            MapleMod.network.sendToAllAround(new PacketUpdateCapability(tileEntity), new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
        }
    }

    protected void onLoad()
    {
        if(!updateNetwork)
            return;

        World world = tileEntity.getWorld();

        if(world == null) {
            Minecraft.getMinecraft().addScheduledTask(() -> onLoad());
            return;
        }

        if (world.isRemote) {
            MapleMod.network.sendToServer(new PacketRequestUpdateTileEntity(tileEntity));
        }
    }
}
