package net.haruneko828.sf_deco.block;

import com.mojang.serialization.MapCodec;
import net.haruneko828.sf_deco.SF_Deco;
import net.haruneko828.sf_deco.block.shape.ModShape;
import net.haruneko828.sf_deco.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class HorizontalPropBlock extends HorizontalDirectionalBlock {
    private final ModShape.HorizontalShapeSet shapes;
    private final ResourceLocation shapeId;

    public HorizontalPropBlock(Properties properties, ResourceLocation shapeId) {
        super(properties);

        this.shapeId = shapeId;
        this.shapes = ModShape.getHorizontalShape(shapeId);

        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public ResourceLocation getShapeId() {
        return shapeId;
    }

    @Override
    protected MapCodec<HorizontalPropBlock> codec() {
        return ModBlockTypes.HORIZONTAL_PROP.get();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return shapes.get(state.getValue(FACING));
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return shapes.get(state.getValue(FACING));
    }

    public static DeferredBlock<HorizontalPropBlock> register(DeferredRegister.Blocks blocks, String name, Properties properties, VoxelShape northShape) {
        ResourceLocation shapeId = ResourceLocation.fromNamespaceAndPath(SF_Deco.MOD_ID, "shape/" + name);

        ModShape.registerHorizontal(shapeId, northShape);

        DeferredBlock<HorizontalPropBlock> block = blocks.register(name, () -> new HorizontalPropBlock(properties, shapeId));
        registerBlockItem(name, block);

        return block;
    }

    public static DeferredBlock<HorizontalPropBlock> register(DeferredRegister.Blocks blocks, String name, Properties properties, VoxelShape northShape, VoxelShape eastShape, VoxelShape southShape, VoxelShape westShape) {
        ResourceLocation shapeId = ResourceLocation.fromNamespaceAndPath(SF_Deco.MOD_ID, "shape/" + name);

        ModShape.registerHorizontal(shapeId, northShape, eastShape, southShape, westShape);

        DeferredBlock<HorizontalPropBlock> block = blocks.register(name, () -> new HorizontalPropBlock(properties, shapeId));

        registerBlockItem(name, block);

        return block;
    }

    private static void registerBlockItem(String name, DeferredBlock<HorizontalPropBlock> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static Supplier<HorizontalPropBlock> create(String name, Properties properties, VoxelShape northShape) {
        ResourceLocation shapeId = ResourceLocation.fromNamespaceAndPath(SF_Deco.MOD_ID, "shape/" + name);

        ModShape.registerHorizontal(shapeId, northShape);

        return () -> new HorizontalPropBlock(properties, shapeId);
    }
}