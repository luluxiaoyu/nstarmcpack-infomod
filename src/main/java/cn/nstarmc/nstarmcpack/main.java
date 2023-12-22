package cn.nstarmc.nstarmcpack;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.session.telemetry.TelemetrySender;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.joml.Matrix4f;

public class main implements ModInitializer {
    public void onInitialize() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            handler.player.sendMessage(Text.of("欢迎使用NSTARMC系列基础模组整合包！by luluxiaoyu"), false);
            handler.player.sendMessage(Text.of("QQ群：796440132"), false);
        });
        HudRenderCallback.EVENT.register((matrixStack, tickDelta) -> {
            renderUsername(matrixStack.getMatrices());
        });
    }
    private void renderUsername(MatrixStack matrixStack) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null) {
            String username = client.player.getName().getString();
            String displayText = "§lUser:" + username;
            int screenWidth = client.getWindow().getScaledWidth();
            int screenHeight = client.getWindow().getScaledHeight();
            int textWidth = client.textRenderer.getWidth(displayText);
            int textHeight = client.textRenderer.fontHeight;
            int x =  10;  // 10 is the right margin
            int y = screenHeight - textHeight - 10;  // 10 is the bottom margin

            matrixStack.push();
            matrixStack.translate(0, 0, 1000);  // Move the text 1000 units away from the camera
            Matrix4f matrix = new Matrix4f();  // 创建一个新的 Matrix4f 对象
            VertexConsumerProvider.Immediate vertexConsumers = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();  // 获取 VertexConsumerProvider
            TextRenderer.TextLayerType layerType = TextRenderer.TextLayerType.NORMAL;  // 设置层类型为 TEXT
            int backgroundColor = 0;  // 设置背景颜色为透明
            int light = 15728880;  // 设置光照

            client.textRenderer.draw(displayText, x, y, 0xFFFFFF, false, matrix, vertexConsumers, layerType, backgroundColor, light);
            matrixStack.pop();

        }
    }





}
