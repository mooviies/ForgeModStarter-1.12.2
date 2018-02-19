package com.mooviies.maplelib.block.tileentity.capability.factory;

import com.mooviies.maplelib.block.tileentity.capability.CapabilityContainer;
import com.mooviies.maplelib.block.tileentity.capability.CapabilityContainerFluid;

public class CapabilityFluidFactory implements ICapabilityContainerFactory {
    @Override
    public CapabilityContainer create() {
        return new CapabilityContainerFluid();
    }
}
