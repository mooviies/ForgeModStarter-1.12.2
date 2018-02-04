package com.mooviies.maplelib.block.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public abstract class MContainer extends Container {

    protected void createPlayerInventory(InventoryPlayer playerInv, int xPosition, int yPosition)
    {
        createPlayerInventory(playerInv, xPosition, yPosition + 58, xPosition, yPosition, 18);
    }

    protected void createPlayerInventory(InventoryPlayer playerInv, int actionbarXPos, int actionbarYPos, int inventoryXPos, int inventoryYPos, int caseSpacing)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, inventoryXPos + j * caseSpacing, inventoryYPos + i * caseSpacing));
            }
        }

        for (int k = 0; k < 9; k++)
        {
            addSlotToContainer(new Slot(playerInv, k, actionbarXPos + k * caseSpacing, actionbarYPos));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack itemStackCopy = ItemStack.EMPTY;
        Slot slot = inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemStack = slot.getStack();
            itemStackCopy = itemStack.copy();

            int containerSlots = inventorySlots.size() - player.inventory.mainInventory.size();

            if (index < containerSlots)
            {
                if (!this.mergeItemStack(itemStack, containerSlots, inventorySlots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemStack, 0, containerSlots, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemStack.getCount() == 0)
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemStack.getCount() == itemStackCopy.getCount())
            {
                return ItemStack.EMPTY;
            }

            slot.onSlotChanged();
        }

        return itemStackCopy;
    }
}
