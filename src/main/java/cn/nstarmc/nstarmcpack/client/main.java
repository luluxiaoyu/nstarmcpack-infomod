package cn.nstarmc.nstarmcpack.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class main implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            long window = MinecraftClient.getInstance().getWindow().getHandle();
            GLFW.glfwSetWindowTitle(window, "NSTARMC ModPack - by luluxiaoyu");
        });
    }
}
