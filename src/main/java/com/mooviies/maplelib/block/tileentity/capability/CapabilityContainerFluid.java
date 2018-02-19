package com.mooviies.maplelib.block.tileentity.capability;

import com.mooviies.maplelib.block.tileentity.MTileEntity;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class CapabilityContainerFluid extends CapabilityContainer {

    private static final String TAG_FLUID = "fluid";

    public CapabilityContainerFluid() {
        this(null, false);
    }

    public CapabilityContainerFluid(MTileEntity tileEntity, boolean updateNetwork) {
        super(tileEntity, updateNetwork);
    }

    @Override
    public void setValues(CapabilityContainer container)
    {

    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        return null;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {

    }

    @Override
    public void toBytes(ByteBuf buf)
    {

    }

    @Override
    public CapabilityContainer fromBytes(ByteBuf buf)
    {
        return this;
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return null;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return false;
    }

    @Override
    public Capability getCapabilityType() {
        return null;
    }

    public <T> T getCapability()
    {
        return null;
    }
}
