package com.mooviies.maplelib.block.tileentity.capability;

import com.mooviies.maplelib.block.tileentity.MTileEntity;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class CapabilityContainerEnergy extends CapabilityContainer {

    private static final String TAG_ENERGY = "energy";

    private MEnergyStorage energyStorage;

    public CapabilityContainerEnergy() {
        this(null, false, 0, 0, 0, 0);
    }

    public CapabilityContainerEnergy(MTileEntity tileEntity, boolean updateNetwork, int capacity, int maxReceive, int maxExtract, int energy)
    {
        super(tileEntity, updateNetwork);
        energyStorage = new MEnergyStorage(capacity, maxReceive, maxExtract, energy)
        {
            @Override
            public void onContentsChanged()
            {
                CapabilityContainerEnergy.this.onContentsChanged();
            }

            @Override
            public void onLoad()
            {
                CapabilityContainerEnergy.this.onLoad();
            }
        };
    }

    public MEnergyStorage getEnergyStorage()
    {
        return energyStorage;
    }

    @Override
    public void setValues(CapabilityContainer container)
    {
        if(container instanceof CapabilityContainerEnergy)
        {
            CapabilityContainerEnergy ce = (CapabilityContainerEnergy)container;
            energyStorage.setMaxExtract(ce.energyStorage.getMaxExtract());
            energyStorage.setMaxReceive(ce.energyStorage.getMaxReceive());
            energyStorage.setCapacity(ce.energyStorage.getMaxEnergyStored());
            energyStorage.setEnergyStored(ce.energyStorage.getEnergyStored());
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setTag(TAG_ENERGY, energyStorage.serializeNBT());
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        energyStorage.deserializeNBT(compound.getCompoundTag(TAG_ENERGY));
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(energyStorage.getMaxEnergyStored());
        buf.writeInt(energyStorage.getMaxReceive());
        buf.writeInt(energyStorage.getMaxExtract());
        buf.writeInt(energyStorage.getEnergyStored());
    }

    @Override
    public CapabilityContainer fromBytes(ByteBuf buf)
    {
        energyStorage.setCapacity(buf.readInt());
        energyStorage.setMaxReceive(buf.readInt());
        energyStorage.setMaxExtract(buf.readInt());
        energyStorage.setEnergyStored(buf.readInt());
        return this;
    }

    @Override
    public boolean is(Capability capability) {
        return capability == net.minecraftforge.energy.CapabilityEnergy.ENERGY;
    }

    @Override
    public Capability getCapabilityType() {
        return net.minecraftforge.energy.CapabilityEnergy.ENERGY;
    }

    @Override
    public <T> T getCapability()
    {
        return (T)energyStorage;
    }
}
