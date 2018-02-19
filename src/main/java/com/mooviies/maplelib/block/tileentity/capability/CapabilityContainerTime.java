package com.mooviies.maplelib.block.tileentity.capability;

import com.mooviies.maplelib.block.tileentity.MTileEntity;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class CapabilityContainerTime extends CapabilityContainer {

    @CapabilityInject(Long.class)
    public static final Capability<Long> TIME = null;
    private static final String TAG_TIME = "time";

    private Long time;

    public CapabilityContainerTime() {
        this(null, false, 0);
    }

    public CapabilityContainerTime(MTileEntity tileEntity, boolean updateNetwork, long time) {
        super(tileEntity, updateNetwork);
        this.time = time;
    }

    @Override
    protected void onContentsChanged()
    {
        if(doUpdateNetwork() && !getTileEntity().getWorld().isRemote)
            time = getTileEntity().getWorld().getTotalWorldTime();

        super.onContentsChanged();
    }

    @Override
    public void setValues(CapabilityContainer container) {
        if(container instanceof CapabilityContainerTime)
        {
            CapabilityContainerTime ct = (CapabilityContainerTime)container;
            time = ct.time;
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setLong(TAG_TIME, time);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        time = compound.getLong(TAG_TIME);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(time);
    }

    @Override
    public CapabilityContainer fromBytes(ByteBuf buf) {
        time = buf.readLong();
        return this;
    }

    @Override
    public boolean is(Capability capability) {
        return capability == TIME;
    }

    @Override
    public Capability getCapabilityType() {
        return TIME;
    }

    @Override
    public <T> T getCapability() {
        return (T)time;
    }
}
