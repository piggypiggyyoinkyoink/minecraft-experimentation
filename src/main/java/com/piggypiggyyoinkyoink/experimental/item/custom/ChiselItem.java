package com.piggypiggyyoinkyoink.experimental.item.custom;

import com.piggypiggyyoinkyoink.experimental.block.ModBlocks;
import com.piggypiggyyoinkyoink.experimental.component.ModDataComponents;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISELMAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.NETHERRACK, Blocks.NETHER_BRICKS,
                    Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE,
                    Blocks.IRON_BLOCK, ModBlocks.DINGUS_BLOCK.get() //have to use .get() for blocks added by the mod
            );

    public ChiselItem(Properties properties){
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
        if(CHISELMAP.containsKey(clickedBlock)){
            if(!level.isClientSide()){
                //only on server - server determines blocks, world, damage etc
                level.setBlockAndUpdate(context.getClickedPos(), CHISELMAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> Objects.requireNonNull(context.getPlayer()).onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
                level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);

                context.getItemInHand().set(ModDataComponents.COORDINATES, context.getClickedPos());
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()){
            tooltipComponents.add(Component.translatable("tooltip.piggypiggyyoinkyoink.chisel.shift_down")); //these tooltips can be named whatever but best to stick with convention
        }else{
            tooltipComponents.add(Component.translatable("tooltip.piggypiggyyoinkyoink.chisel"));

        }
        if(stack.get(ModDataComponents.COORDINATES) != null){
            tooltipComponents.add(Component.literal("Last Block changed at " + stack.get(ModDataComponents.COORDINATES)));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
