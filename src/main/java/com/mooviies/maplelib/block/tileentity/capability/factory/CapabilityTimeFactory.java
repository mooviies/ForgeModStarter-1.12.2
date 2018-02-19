package com.mooviies.maplelib.block.tileentity.capability.factory;

import com.mooviies.maplelib.block.tileentity.capability.CapabilityContainer;
import com.mooviies.maplelib.block.tileentity.capability.CapabilityContainerTime;

public class CapabilityTimeFactory implements ICapabilityContainerFactory {
    @Override
    public CapabilityContainer create() {
        return new CapabilityContainerTime();
    }
}
