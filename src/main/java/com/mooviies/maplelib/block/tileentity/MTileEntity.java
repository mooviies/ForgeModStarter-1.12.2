package com.mooviies.maplelib.block.tileentity;

import com.mooviies.maplelib.block.tileentity.capability.CapabilityContainer;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Set;

public class MTileEntity extends TileEntity {

    private HashMap<Capability, CapabilityContainer> capabilities = new HashMap<>();

    public Set<Capability> getCapabilities()
    {
        return capabilities.keySet();
    }

    public CapabilityContainer getCapabilityContainer(Capability capability, @Nullable EnumFacing facing) {
        return capabilities.getOrDefault(capability, null);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        for(CapabilityContainer capability : capabilities.values())
        {
            capability.writeToNBT(compound);
        }
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        for(CapabilityContainer capability : capabilities.values())
        {
            capability.readFromNBT(compound);
        }
        super.readFromNBT(compound);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capabilities.containsKey(capability) || super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return capabilities.containsKey(capability) ? capabilities.get(capability).getCapability() : super.getCapability(capability, facing);
    }

    protected final void addCapability(CapabilityContainer capability)
    {
        if(!capabilities.containsKey(capability.getCapabilityType()) && !capabilities.containsKey(capability.getCapabilityType()))
        {
            capabilities.put(capability.getCapabilityType(), capability);
        }
        else
            throw new RuntimeException("Tile Entities can only have one type of each capabilities. This tile entity already has the capability : " + capability.getCapabilityType());


    }
}