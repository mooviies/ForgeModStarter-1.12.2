package com.mooviies.maplelib.block.tileentity.capability.factory;

import com.mooviies.maplelib.block.tileentity.capability.CapabilityContainer;
import com.mooviies.maplelib.block.tileentity.capability.CapabilityContainerInventory;

public class CapabilityInventoryFactory implements ICapabilityContainerFactory {
    @Override
    public CapabilityContainer create() {
        return new CapabilityContainerInventory();
    }
}
