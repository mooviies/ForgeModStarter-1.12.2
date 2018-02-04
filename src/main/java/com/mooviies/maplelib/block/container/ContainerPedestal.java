package com.mooviies.maplelib.block.container;

import com.mooviies.maplelib.block.tileentity.TileEntityPedestal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerPedestal extends MContainer {

    public ContainerPedestal(InventoryPlayer playerInv, final TileEntityPedestal pedestal) {
        IItemHandler inventory = pedestal.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        addSlotToContainer(new SlotItemHandler(inventory, 0, 80, 35) {
            @Override
            public void onSlotChanged() {
                pedestal.markDirty();
            }
        });

        createPlayerInventory(playerInv, 8, 84);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }
}
