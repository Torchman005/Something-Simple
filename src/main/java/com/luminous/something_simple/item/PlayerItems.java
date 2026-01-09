package com.luminous.something_simple.item;

import com.luminous.something_simple.Something_simple;
import com.luminous.something_simple.sound.CustomDisc;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PlayerItems {
//    延迟注册表
    public static final DeferredRegister.Items PLAYER_ITEMS = DeferredRegister.createItems(Something_simple.MODID);
// 注册物品，第一个参数为名称（和modid命名规则一样）,第二个参数为supplier
    public static final DeferredItem<Item> PLAYER_STARTER = PLAYER_ITEMS.register("player_starter",
        () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PlUS_SONG_MUSIC_DISC = PLAYER_ITEMS.register("plus_song_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(CustomDisc.PLUS_SONG_KEY).stacksTo(1)));
// 注册到mod事件总线
    public static void register(IEventBus eventBus) {
        PLAYER_ITEMS.register(eventBus);
    }
}
