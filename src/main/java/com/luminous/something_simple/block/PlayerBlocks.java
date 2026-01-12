package com.luminous.something_simple.block;

import com.luminous.something_simple.Something_simple;
import com.luminous.something_simple.item.PlayerItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class PlayerBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Something_simple.MODID);



    public static final DeferredBlock<Block> PLAYER_BLOCK = registerBlock("player_block",
            // () -> DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of())
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0F, 6.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)
                    .lightLevel(state -> 15)
    ));

    public static final DeferredBlock<Block> CHARRED_IRON_BLOCK = registerBlock("charred_iron_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0F, 6.0F)
                    .requiresCorrectToolForDrops()
    ));

    // 注册方块工具方法
     private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
         DeferredBlock<T> toReturn = BLOCKS.register(name, block);
         registerBlockItem(name, toReturn);
         return toReturn;
     }

    // 注册方块比较麻烦，因为你需要再注册一个跟这个方块相关的物品，所以这里写个工具方法来注册
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        PlayerItems.PLAYER_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
