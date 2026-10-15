package net.haruneko828.sf_deco.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.haruneko828.sf_deco.SF_Deco;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockTypes {
    public static final DeferredRegister<MapCodec<? extends Block>> BLOCK_TYPE =
            DeferredRegister.create(BuiltInRegistries.BLOCK_TYPE, SF_Deco.MOD_ID);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<HorizontalPropBlock>> HORIZONTAL_PROP = BLOCK_TYPE.register("horizontal_prop",
            () -> RecordCodecBuilder.mapCodec(instance -> instance.group(
                    ResourceLocation.CODEC.fieldOf("shape").forGetter(HorizontalPropBlock::getShapeId),
                    BlockBehaviour.propertiesCodec()).apply(instance, (shapeId, properties)
                    -> new HorizontalPropBlock(properties, shapeId)
            )));

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<DirectionalPropBlock>> DIRECTIONAL_PROP = BLOCK_TYPE.register("directional_prop",
            () -> RecordCodecBuilder.mapCodec(instance -> instance.group(
                    ResourceLocation.CODEC.fieldOf("shape").forGetter(DirectionalPropBlock::getShapeId),
                    BlockBehaviour.propertiesCodec()).apply(instance, (shapeId, properties)
                    -> new DirectionalPropBlock(properties, shapeId)
            )));

    public static void register(IEventBus eventBus) {
        BLOCK_TYPE.register(eventBus);
    }
}
