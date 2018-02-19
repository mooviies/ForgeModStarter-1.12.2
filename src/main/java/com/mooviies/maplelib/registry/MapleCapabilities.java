package com.mooviies.maplelib.registry;

import com.mooviies.maplelib.block.tileentity.capability.CapabilityContainer;
import com.mooviies.maplelib.block.tileentity.capability.factory.CapabilityEnergyFactory;
import com.mooviies.maplelib.block.tileentity.capability.factory.CapabilityInventoryFactory;
import com.mooviies.maplelib.block.tileentity.capability.factory.ICapabilityContainerFactory;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;

import java.util.HashMap;

public class MapleCapabilities {

    private static int nextId = 0;
    private static HashMap<Integer, Capability> capabilities = new HashMap<>();
    private static HashMap<Integer, ICapabilityContainerFactory> factories = new HashMap<>();
    private static HashMap<Capability, Integer> capabilitiesUID = new HashMap<>();

    public static void init()
    {
        register(CapabilityEnergy.ENERGY, new CapabilityEnergyFactory());
        //register(CapabilityTypeBase.FLUID);
        register(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, new CapabilityInventoryFactory());
    }

    public static void register(Capability capability, ICapabilityContainerFactory factory) {
        if(capabilitiesUID.containsKey(capability))
            throw new RuntimeException("Capability " + capability + " is already registered.");

        int uid = nextId++;
        capabilities.put(uid, capability);
        capabilitiesUID.put(capability, uid);
        factories.put(uid, factory);
    }

    public static CapabilityContainer createCapabilityContainer(int id)
    {
        return factories.get(id).create();
    }

    public static Capability getCapabilityType(int id)
    {
        return capabilities.get(id);
    }

    public static Integer getUID(Capability capability)
    {
        return capabilitiesUID.get(capability);
    }
}
