package vanilla.wildsregrown.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.util.InputUtil;

public class KeyBindings {

    public static boolean hasKeyDown(KeyInput input){
        return hasKeyDown(input.getKeycode());
    }
    public static boolean hasKeyDown(int code) {
        return InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow(), code);
    }

}
