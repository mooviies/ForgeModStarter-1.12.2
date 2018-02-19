package com.mooviies.maplelib;

import com.mooviies.maplelib.network.PacketRequestUpdateTileEntity;
import com.mooviies.maplelib.network.PacketUpdateCapability;
import com.mooviies.maplelib.proxy.CommonProxy;
import com.mooviies.maplelib.registry.MapleBlocks;
import com.mooviies.maplelib.client.MapleTab;
import com.mooviies.maplelib.registry.MapleCapabilities;
import com.mooviies.maplelib.registry.MapleItems;
import com.mooviies.maplelib.registry.MapleRecipes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = MapleMod.MODID, name = MapleMod.NAME, version = MapleMod.VERSION)
public class MapleMod
{
    public static final String GROUPID = "com.mooviies";
    public static final String MODID = "maplelib";
    public static final String PACKAGE = GROUPID + "." + MODID;
    public static final String NAME = "Maple Minecraft Library";
    public static final String VERSION = "1.12.2-0.0.4.0";
    public static final MapleTab CREATIVE_TAB = null;
    public static final MapleModDescriptor DESCRIPTOR = new MapleLibraryDescriptor();

    public static SimpleNetworkWrapper network;

    @SidedProxy(serverSide = PACKAGE + ".proxy.CommonProxy", clientSide = PACKAGE + ".proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MODID)
    public static MapleMod instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println(NAME + " is loading!");
        MapleCapabilities.init();

        network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
        network.registerMessage(new PacketUpdateCapability.Handler(), PacketUpdateCapability.class, 0, Side.CLIENT);
        network.registerMessage(new PacketRequestUpdateTileEntity.Handler(), PacketRequestUpdateTileEntity.class, 1, Side.SERVER);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MapleBlocks.init();
        MapleItems.init();
        MapleRecipes.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent(priority = EventPriority.LOWEST)
        public static void registerItems(RegistryEvent.Register<Item> event) {
            MapleItems.register(event.getRegistry());
            MapleBlocks.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent(priority = EventPriority.LOWEST)
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            MapleBlocks.register(event.getRegistry());
        }

        @SubscribeEvent(priority = EventPriority.LOWEST)
        public static void registerItems(ModelRegistryEvent event) {
            MapleItems.registerModels();
            MapleBlocks.registerItemModels();
        }
    }
}
