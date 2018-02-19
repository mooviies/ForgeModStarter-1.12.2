package com.mooviies.maplelib.network;

import com.mooviies.maplelib.block.tileentity.MTileEntity;
import com.mooviies.maplelib.block.tileentity.capability.CapabilityContainer;
import com.mooviies.maplelib.registry.MapleCapabilities;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.HashMap;
import java.util.Set;

public class PacketUpdateCapability implements IMessage {

    private BlockPos pos;
    private HashMap<Capability, CapabilityContainer> capabilities = new HashMap<>();

    public PacketUpdateCapability(BlockPos pos, CapabilityContainer... capabilityContainers)
    {
        this.pos = pos;
        for(CapabilityContainer capability: capabilityContainers)
            capabilities.put(capability.getCapabilityType(), capability);
    }

    public PacketUpdateCapability(MTileEntity te)
    {
        this.pos = te.getPos();
        for(Capability capability : te.getCapabilities())
            this.capabilities.put(capability, te.getCapabilityContainer(capability, null));
    }

    public PacketUpdateCapability()
    {
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        int nbCapability = buf.readInt();
        for(int i = 0; i < nbCapability; i++)
        {
            int id = buf.readInt();
            Capability capability = MapleCapabilities.getCapabilityType(id);
            capabilities.put(capability, MapleCapabilities.createCapabilityContainer(id).fromBytes(buf));
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {

        int size = capabilities.size();
        buf.writeInt(size);
        for(Capability capability : capabilities.keySet())
        {
            buf.writeInt(MapleCapabilities.getUID(capability));
            capabilities.get(capability).toBytes(buf);
        }
    }

    public static class Handler implements IMessageHandler<PacketUpdateCapability, IMessage> {

        @Override
        public IMessage onMessage(PacketUpdateCapability message, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(() -> {
                MTileEntity te = (MTileEntity)Minecraft.getMinecraft().world.getTileEntity(message.pos);
                for(Capability capability : message.capabilities.keySet())
                {
                    te.getCapabilityContainer(capability, null).setValues(message.capabilities.get(capability));
                }
            });
            return null;
        }

    }
}
