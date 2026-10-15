package net.haruneko828.sf_deco.block;

import com.mojang.serialization.MapCodec;
import net.haruneko828.sf_deco.SF_Deco;
import net.haruneko828.sf_deco.block.shape.ModShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class DirectionalPropBlock extends DirectionalBlock {
    private final ModShape.DirectionalShapeSet shapes;
    private final ResourceLocation shapeId;

    public DirectionalPropBlock(BlockBehaviour.Properties properties, ResourceLocation shapeId) {
        super(properties);

        this.shapeId = shapeId;
        this.shapes = ModShape.getDirectionalShape(shapeId);

        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
    public ResourceLocation getShapeId() {
        return shapeId;
    }

    @Override
    protected MapCodec<DirectionalPropBlock> codec() {
        return ModBlockTypes.DIRECTIONAL_PROP.get();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite());
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.setValue(FACING, mirror.mirror(state.getValue(FACING)));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return shapes.get(state.getValue(FACING));
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return shapes.get(state.getValue(FACING));
    }

    public static Supplier<DirectionalPropBlock> create(String name, BlockBehaviour.Properties properties, VoxelShape northShape) {
        ResourceLocation shapeId = ResourceLocation.fromNamespaceAndPath(SF_Deco.MOD_ID, "shape/" + name);

        ModShape.registerDirectional(shapeId, northShape);
        return () -> new DirectionalPropBlock(properties, shapeId);
    }

    public static Supplier<DirectionalPropBlock> create(String name, BlockBehaviour.Properties properties, VoxelShape northShape, VoxelShape eastShape, VoxelShape southShape, VoxelShape westShape, VoxelShape upShape,VoxelShape downShape) {
        ResourceLocation shapeId = ResourceLocation.fromNamespaceAndPath(SF_Deco.MOD_ID, "shape/" + name);

        ModShape.registerDirectional(shapeId, northShape, eastShape, southShape, westShape, upShape, downShape);
        return () -> new DirectionalPropBlock(properties, shapeId);
    }
}
