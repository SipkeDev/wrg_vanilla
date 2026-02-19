package vanilla.wildsregrown.network;

import com.sipke.api.features.Colors;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.*;
import vanilla.wildsregrown.WRGVanilla;

import java.net.URI;
import java.util.*;

public class Networking {

    public static Text[] textArray;

    public static List<ServerPlayerEntity> connected_players = new ArrayList<>();

    public static void connectHandler(ServerPlayerEntity player) {
        for (ServerPlayerEntity entity : connected_players) {
            entity.sendMessage(Text.of("People are joining the server!"));
        }
        connected_players.add(player);
        int i = player.getRandom().nextInt(textArray.length);
        player.sendMessage(textArray[i]);
        WRGVanilla.LOGGER.info(textArray[i].getLiteralString());
    }

    public static void disconnectHandler(MinecraftServer server, ServerPlayNetworkHandler playNetworkHandler) {
        connected_players.remove(playNetworkHandler.player);
        for (ServerPlayerEntity entity : connected_players) {
            entity.sendMessage(Text.of("People are leaving the server..."));
        }
    }

    public static void init() {
        PayloadTypeRegistry.playC2S().register(ConnectMessage.PACKET_ID, ConnectMessage.codec);

        ServerPlayNetworking.registerGlobalReceiver(ConnectMessage.PACKET_ID, (payload, context) -> Networking.connectHandler(context.player()));
        ServerPlayConnectionEvents.DISCONNECT.register((playNetworkHandler, server) -> Networking.disconnectHandler(server, playNetworkHandler));
    }

    static {
        textArray = new Text[11];
        Style discord = Text.empty().getStyle().withColor(Colors.darkPastelRed).withClickEvent(new ClickEvent.OpenUrl(URI.create("https://discord.gg/Kr6veDaJDr")));

        //4 fun
        textArray[0] = Text.literal("Make sure to use /wrg to find generation features quickly.");
        textArray[1] = Text.literal("The world awaits!");
        textArray[2] = Text.literal("Time too explore!");
        textArray[3] = Text.literal("What is your favorite world type?");
        textArray[4] = Text.literal("What are you going to build today?");
        textArray[5] = Text.literal("Erosion makes the world load slow(er)");
        textArray[6] = Text.literal("Erosion makes the world look cool(er)");

        //Discord invites
        textArray[7] = Text.literal("Showcase your best screenshots on Discord!").setStyle(discord);
        textArray[8] = Text.literal("Alpha mod: Please report found bugs!").setStyle(discord);
        textArray[9] = Text.literal("Idea for a biome? Share it on discord!").setStyle(discord);

        //Wilds Regrown marketing
        textArray[10] = Text.literal("Checkout Wilds Regrown, for even more spectacular world gen and cool building blocks!")
                .setStyle(Text.empty().getStyle().withColor(Colors.richLilac).withBold(true).withClickEvent(new ClickEvent.OpenUrl(URI.create("https://discord.gg/Kr6veDaJDr"))));
    }

}
