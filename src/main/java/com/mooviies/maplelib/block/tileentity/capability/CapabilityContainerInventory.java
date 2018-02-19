package com.mooviies.maplelib.block.tileentity.capability;

import com.mooviies.maplelib.block.tileentity.MTileEntity;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class CapabilityContainerInventory extends CapabilityContainer {

    private static final String TAG_INVENTORY = "inventory";

    private ItemStackHandler inventory;

    public CapabilityContainerInventory() {
        this(null, false, 1);
    }

    public CapabilityContainerInventory(MTileEntity tileEntity, boolean updateNetwork, int size)
    {
        super(tileEntity, updateNetwork);
        inventory = new ItemStackHandler(size){
            @Override
            public void onContentsChanged(int slot)
            {
                CapabilityContainerInventory.this.onContentsChanged();
            }

            @Override
            public void onLoad()
            {
                CapabilityContainerInventory.this.onLoad();
            }
        };
    }

    @Override
    public void setValues(CapabilityContainer container)
    {
        if(container instanceof CapabilityContainerInventory)
        {
            CapabilityContainerInventory ci = (CapabilityContainerInventory)container;
            if(inventory.getSlots() != ci.inventory.getSlots())
                inventory.setSize(ci.inventory.getSlots());

            for(int i = 0; i < inventory.getSlots(); i++)
            {
                inventory.setStackInSlot(i, ci.inventory.getStackInSlot(i));
            }
        }
    }

    public void setInventory(ItemStackHandler inventory)
    {
        this.inventory = inventory;
    }

    public ItemStackHandler getInventory()
    {
        return inventory;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setTag(TAG_INVENTORY, inventory.serializeNBT());
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        inventory.deserializeNBT(compound.getCompoundTag(TAG_INVENTORY));
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        int nbSlots = inventory.getSlots();
        buf.writeInt(nbSlots);
        for(int i = 0; i < nbSlots; i++)
        {
            ByteBufUtils.writeItemStack(buf, inventory.getStackInSlot(i));
        }
    }

    @Override
    public CapabilityContainer fromBytes(ByteBuf buf)
    {
        int nbSlots = buf.readInt();

        if(nbSlots != inventory.getSlots())
            inventory.setSize(nbSlots);

        for(int i = 0; i < nbSlots; i++)
        {
            inventory.setStackInSlot(i, ByteBufUtils.readItemStack(buf));
        }

        return this;
    }

    @Override
    public boolean is(Capability capability) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
    }

    @Override
    public Capability getCapabilityType() {
        return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
    }

    @Override
    public <T> T getCapability()
    {
        return (T)inventory;
    }
}
