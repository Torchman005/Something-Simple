package com.luminous.something_simple.item;

import com.luminous.something_simple.Something_simple;
import com.luminous.something_simple.block.PlayerBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Something_simple.MODID);

    public static final Supplier<CreativeModeTab> SOMETHING_SIMPLE_ITEM_TAB = CREATIVE_MODE_TAB.register("something_simple_item_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(PlayerItems.PLAYER_STARTER.get()))
                    .title(Component.translatable("creativetab.something_simple.something_simple_items"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(PlayerItems.PLAYER_STARTER);

                        output.accept(PlayerItems.PlUS_SONG_MUSIC_DISC);

                        output.accept(PlayerItems.CHARRED_IRON_INGOT);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> SOMETHING_SIMPLE_BLOCK_TAB = CREATIVE_MODE_TAB.register("something_simple_block_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(PlayerBlocks.PLAYER_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Something_simple.MODID, "something_simple_item_tab"))
                    .title(Component.translatable("creativetab.something_simple.something_simple_blocks"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(PlayerBlocks.PLAYER_BLOCK);
                        
                        output.accept(PlayerBlocks.CHARRED_IRON_BLOCK);
                    })
                    .build());

    public static final void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
