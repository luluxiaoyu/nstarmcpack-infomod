package cn.nstarmc.nstarmcpack;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.text.Text;

public class main implements ModInitializer {
    public void onInitialize() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            handler.player.sendMessage(Text.of("欢迎使用NSTARMC系列基础模组整合包！by luluxiaoyu"), false);
            handler.player.sendMessage(Text.of("QQ群：796440132"), false);
        });
    }
}
