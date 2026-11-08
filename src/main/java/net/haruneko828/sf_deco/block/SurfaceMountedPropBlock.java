package net.haruneko828.sf_deco.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
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
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class SurfaceMountedPropBlock extends DirectionalBlock {
    public static final DirectionProperty HORIZONTAL_ROTATION = DirectionProperty.create("horizontal_rotation",
            Direction.Plane.HORIZONTAL);

    public static final MapCodec<SurfaceMountedPropBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    BlockBehaviour.propertiesCodec(),
                    ResourceLocation.CODEC.fieldOf("shape").forGetter(SurfaceMountedPropBlock::getShapeId)).apply(instance, SurfaceMountedPropBlock::new));

    private final ResourceLocation shapeId;
    private final ModShape.SurfaceMountedShapeSet shapes;

    public SurfaceMountedPropBlock(Properties properties, ResourceLocation shapeId) {
        super(properties);

        this.shapeId = shapeId;
        this.shapes = ModShape.getSurfaceMountedShape(shapeId);

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(HORIZONTAL_ROTATION, Direction.NORTH));
    }

    public ResourceLocation getShapeId() {
        return this.shapeId;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HORIZONTAL_ROTATION);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction facing = context.getNearestLookingDirection().getOpposite();

        Direction horizontalRotation = facing.getAxis().isVertical() ? context.getHorizontalDirection().getOpposite() : Direction.NORTH;

        return this.defaultBlockState()
                .setValue(FACING, facing)
                .setValue(HORIZONTAL_ROTATION, horizontalRotation);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return this.shapes.get(
                state.getValue(FACING),
                state.getValue(HORIZONTAL_ROTATION));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return this.shapes.get(
                state.getValue(FACING),
                state.getValue(HORIZONTAL_ROTATION));
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        Direction facing = state.getValue(FACING);

        if (facing.getAxis().isVertical()) {
            return state.setValue(HORIZONTAL_ROTATION, rotation.rotate(state.getValue(HORIZONTAL_ROTATION)));
        }
        return state.setValue(FACING, rotation.rotate(facing));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        Direction facing = state.getValue(FACING);

        if (facing.getAxis().isVertical()) {
            return state.setValue(HORIZONTAL_ROTATION, mirror.mirror(state.getValue(HORIZONTAL_ROTATION)));
        }
        return state.setValue(FACING, mirror.mirror(facing));
    }

    public static Supplier<SurfaceMountedPropBlock> create(String name, Properties properties, VoxelShape northShape) {
        ResourceLocation shapeId = ResourceLocation.fromNamespaceAndPath(SF_Deco.MOD_ID, "shape/" + name);

        ModShape.registerSurfaceMounted(shapeId, northShape);

        return () -> new SurfaceMountedPropBlock(properties, shapeId);
    }

    @Override
    public MapCodec<SurfaceMountedPropBlock> codec() {
        return ModBlockTypes.SURFACE_MOUNTED_PROP.get();
    }
}

