package com.mooviies.maplelib.block.tileentity.capability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.energy.EnergyStorage;

class MEnergyStorage extends EnergyStorage implements INBTSerializable<NBTTagCompound> {

    private static final String TAG_ENERGY = "energy";
    private static final String TAG_CAPACITY = "capacity";
    private static final String TAG_MAX_RECEIVE = "max_receive";
    private static final String TAG_MAX_EXTRACT = "max_extract";

    public MEnergyStorage(int capacity, int maxReceive, int maxExtract, int energy)
    {
        super(capacity, maxReceive, maxExtract, energy);
    }

    public int getMaxReceive() { return maxReceive; }
    public int getMaxExtract() { return maxExtract; }

    public void setMaxReceive(int maxReceive) { this.maxReceive = maxReceive; }
    public void setMaxExtract(int maxExtract) { this.maxExtract = maxExtract; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setEnergyStored(int energy) { this.energy = energy; }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger(TAG_ENERGY, energy);
        nbt.setInteger(TAG_CAPACITY, capacity);
        nbt.setInteger(TAG_MAX_RECEIVE, maxReceive);
        nbt.setInteger(TAG_MAX_EXTRACT, maxExtract);
        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        energy = nbt.getInteger(TAG_ENERGY);
        capacity = nbt.getInteger(TAG_CAPACITY);
        maxReceive = nbt.getInteger(TAG_MAX_RECEIVE);
        maxExtract = nbt.getInteger(TAG_MAX_EXTRACT);
        onLoad();
    }

    @Override
    public int receiveEnergy(int receive, boolean simulate)
    {
        if (!canReceive())
            return 0;

        int energyReceived = 0;
        int availableSpace = capacity - energy;

        receive = Math.min(receive, maxReceive);

        if(receive > availableSpace)
        {
            energyReceived = availableSpace;
        }
        else
        {
            energyReceived = receive;
        }

        if (!simulate)
        {
            energy += energyReceived;
            onContentsChanged();
        }

        return energyReceived;
    }

    @Override
    public int extractEnergy(int extract, boolean simulate)
    {
        if (!canExtract())
            return 0;

        int energyExtracted = 0;
        extract = Math.min(extract, maxExtract);

        if(extract > energy)
        {
            energyExtracted = energy;
        }
        else
        {
            energyExtracted = extract;
        }

        if (!simulate)
        {
            energy -= energyExtracted;
            onContentsChanged();
        }

        return energyExtracted;
    }

    protected void onLoad()
    {

    }

    protected void onContentsChanged()
    {

    }
}
