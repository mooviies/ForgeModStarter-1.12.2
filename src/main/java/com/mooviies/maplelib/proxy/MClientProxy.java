package com.mooviies.maplelib.proxy;

import com.mooviies.maplelib.MapleMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class MClientProxy extends MCommonProxy {
    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(MapleMod.MODID + ":" + id, "inventory"));
    }
}
