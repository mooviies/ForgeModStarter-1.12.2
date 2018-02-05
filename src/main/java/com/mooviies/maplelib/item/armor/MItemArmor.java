package com.mooviies.maplelib.item.armor;

import com.mooviies.maplelib.MapleMod;
import com.mooviies.maplelib.MapleModDescriptor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class MItemArmor extends ItemArmor {

    private String name;
    protected MapleModDescriptor modDescriptor;
    private static ArrayList<MItemArmor> items = new ArrayList<>();

    public MItemArmor(MapleModDescriptor modDescriptor, String name, ArmorMaterial material, EntityEquipmentSlot slot) {
        super(material, 0, slot);
        initialize(modDescriptor, name);
    }

    public static void register(IForgeRegistry<Item> registry) {

        for(MItemArmor item : items)
            registry.register(item);
    }

    public static void registerItemModel() {
        for(MItemArmor item : items)
            MapleMod.proxy.registerItemRenderer(item.modDescriptor, item, 0, item.name);
    }

    @Override
    public MItemArmor setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    private void initialize(MapleModDescriptor modDescriptor, String name)
    {
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
        items.add(this);

        this.modDescriptor = modDescriptor;
        setCreativeTab(modDescriptor.getCreativeTab());
    }
}
