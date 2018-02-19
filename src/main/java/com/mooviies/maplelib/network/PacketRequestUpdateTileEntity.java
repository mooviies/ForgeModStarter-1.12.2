package com.mooviies.maplelib.network;

import com.mooviies.maplelib.block.tileentity.MTileEntity;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketRequestUpdateTileEntity implements IMessage {
    private BlockPos pos;
    private int dimension;

    public PacketRequestUpdateTileEntity(BlockPos pos, int dimension) {
        this.pos = pos;
        this.dimension = dimension;
    }

    public PacketRequestUpdateTileEntity(MTileEntity te) {
        this(te.getPos(), te.getWorld().provider.getDimension());
    }

    public PacketRequestUpdateTileEntity() {
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(pos.toLong());
        buf.writeInt(dimension);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        pos = BlockPos.fromLong(buf.readLong());
        dimension = buf.readInt();
    }

    public static class Handler implements IMessageHandler<PacketRequestUpdateTileEntity, PacketUpdateCapability> {

        @Override
        public PacketUpdateCapability onMessage(PacketRequestUpdateTileEntity message, MessageContext ctx) {
            World world = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(message.dimension);
            MTileEntity tileEntity = (MTileEntity)world.getTileEntity(message.pos);
            if (tileEntity != null)
            {
                return new PacketUpdateCapability(tileEntity);
            }
            else
            {
                return null;
            }
        }

    }
}
