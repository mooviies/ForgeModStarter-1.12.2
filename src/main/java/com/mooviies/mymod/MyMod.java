package com.mooviies.mymod;

import com.mooviies.mymod.registry.ModBlocks;
import com.mooviies.mymod.client.MyModTab;
import com.mooviies.mymod.registry.ModItems;
import com.mooviies.mymod.material.ModMaterials;
import com.mooviies.mymod.proxy.CommonProxy;
import com.mooviies.mymod.registry.ModRecipes;
import com.mooviies.mymod.world.ModWorldGen;
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
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = MyMod.MODID, name = MyMod.NAME, version = MyMod.VERSION)
public class MyMod
{
    public static final String GROUPID = "com.mooviies";
    public static final String MODID = "mymod";
    public static final String PACKAGE = GROUPID + "." + MODID;
    public static final String NAME = "My Mod";
    public static final String VERSION = "1.0.0";

    @SidedProxy(serverSide = PACKAGE + ".proxy.CommonProxy", clientSide = PACKAGE+ ".proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MODID)
    public static MyMod instance;

    public static final MyModTab creativeTab = new MyModTab();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println(NAME + " is loading!");
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModBlocks.init();
        ModItems.init();
        ModRecipes.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
            ModBlocks.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            ModBlocks.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event) {
            ModItems.registerModels();
            ModBlocks.registerItemModels();
        }
    }
}
