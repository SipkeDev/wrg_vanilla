package vanilla.wildsregrown.network;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import vanilla.wildsregrown.WRGVanilla;

public class ConnectMessage implements CustomPayload {

    public static final Identifier welcome = Identifier.of(WRGVanilla.modid, "welcome_screen");
    public static final Id<ConnectMessage> PACKET_ID = new Id<>(welcome);
    public static final PacketCodec<RegistryByteBuf, ConnectMessage> codec = PacketCodec.of(ConnectMessage::write, ConnectMessage::read);

    public static ConnectMessage read(RegistryByteBuf buf) {
        return new ConnectMessage();
    }

    public void write(RegistryByteBuf buf) {}

    @Override
    public Id<? extends CustomPayload> getId() {
        return PACKET_ID;
    }

}
