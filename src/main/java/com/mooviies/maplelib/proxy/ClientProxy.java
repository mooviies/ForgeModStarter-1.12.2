package com.mooviies.maplelib.proxy;

import com.mooviies.maplelib.MapleModDescriptor;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerItemRenderer(MapleModDescriptor modDescriptor, Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(modDescriptor.getModID() + ":" + id, "inventory"));
    }
}
