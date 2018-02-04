package com.mooviies.maplelib;

import com.mooviies.maplelib.gui.MapleGuiHandler;
import com.mooviies.maplelib.proxy.MCommonProxy;
import com.mooviies.maplelib.registry.MapleBlocks;
import com.mooviies.maplelib.client.MapleTab;
import com.mooviies.maplelib.registry.MapleItems;
import com.mooviies.maplelib.registry.MapleRecipes;
import com.mooviies.maplelib.world.MWorldGen;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = MapleMod.MODID, name = MapleMod.NAME, version = MapleMod.VERSION)
public class MapleMod
{
    public static final String GROUPID = "com.mooviies";
    public static final String MODID = "maplelib";
    public static final String PACKAGE = GROUPID + "." + MODID;
    public static final String NAME = "Maple Minecraft Library";
    public static final String VERSION = "1.0.0";

    @SidedProxy(serverSide = PACKAGE + ".proxy.MCommonProxy", clientSide = PACKAGE+ ".proxy.MClientProxy")
    public static MCommonProxy proxy;

    @Mod.Instance(MODID)
    public static MapleMod instance;

    public static final MapleTab creativeTab = new MapleTab();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println(NAME + " is loading!");
        GameRegistry.registerWorldGenerator(new MWorldGen(), 3);
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new MapleGuiHandler());
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

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            MapleItems.register(event.getRegistry());
            MapleBlocks.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            MapleBlocks.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event) {
            MapleItems.registerModels();
            MapleBlocks.registerItemModels();
        }
    }
}
