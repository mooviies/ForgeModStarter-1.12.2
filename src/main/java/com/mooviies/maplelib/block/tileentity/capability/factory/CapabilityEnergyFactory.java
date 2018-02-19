package com.mooviies.maplelib.block.tileentity.capability.factory;

import com.mooviies.maplelib.block.tileentity.capability.CapabilityContainer;
import com.mooviies.maplelib.block.tileentity.capability.CapabilityContainerEnergy;

public class CapabilityEnergyFactory implements ICapabilityContainerFactory {
    @Override
    public CapabilityContainer create() {
        return new CapabilityContainerEnergy();
    }
}
