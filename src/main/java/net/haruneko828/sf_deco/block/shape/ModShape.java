package net.haruneko828.sf_deco.block.shape;

import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModShape {
    private static final Map<ResourceLocation, HorizontalShapeSet> HORIZONTAL_SHAPES = new HashMap<>();
    private static final Map<ResourceLocation, DirectionalShapeSet> DIRECTIONAL_SHAPES = new HashMap<>();

    private ModShape() {

    }

    public static void registerHorizontal(ResourceLocation id, VoxelShape north) {
        registerHorizontal(id, north, rotateNorthToEast(north), rotateNorthToSouth(north), rotateNorthToWest(north));
    }

    public static void registerHorizontal(ResourceLocation id, VoxelShape north, VoxelShape east, VoxelShape south, VoxelShape west) {
        if (HORIZONTAL_SHAPES.putIfAbsent(id, new HorizontalShapeSet(north, east, south, west)) !=null) {
            throw new IllegalStateException("Duplicate SF Deco horizontal shape: " + id);
        }
    }

    public static HorizontalShapeSet getHorizontalShape(ResourceLocation id) {
        HorizontalShapeSet shapes = HORIZONTAL_SHAPES.get(id);
        if (shapes == null) {
            throw new IllegalStateException("Unknown SF Deco horizontal shape: " + id);
        }
        return shapes;
    }

    private static VoxelShape rotateNorthToEast(VoxelShape shape) {
        return transformShape(shape, 1);
    }

    private static VoxelShape rotateNorthToSouth(VoxelShape shape) {
        return transformShape(shape, 2);
    }

    private static VoxelShape rotateNorthToWest(VoxelShape shape) {
        return transformShape(shape, 3);
    }

    private static VoxelShape transformShape(VoxelShape source, int quarterTurns) {
        return transformShape(source, box -> rotateBox(box, quarterTurns));
    }

    private static VoxelShape transformShapeX(VoxelShape source, int quarterTurns) {
        return transformShape(source, box ->rotateBoxX(box, quarterTurns));
    }

    private static VoxelShape transformShape(VoxelShape source, java.util.function.UnaryOperator<AABB> transform) {
        List<VoxelShape> boxes = source.toAabbs().stream().map(transform).map(Shapes::create).toList();

        if (boxes.isEmpty()) {
            return Shapes.empty();
        }

        if (boxes.size() == 1) {
            return boxes.getFirst();
        }

        VoxelShape result = boxes.getFirst();

        for (int i = 1; i < boxes.size(); i++) {
            result = Shapes.or(result, boxes.get(i));
        }
        return result;
    }

    private static AABB rotateBox(AABB box, int quarterTurns) {
        return switch (quarterTurns) {
            case 1 -> new AABB(1.0 - box.maxZ, box.minY, box.minX, 1.0 - box.minZ, box.maxY, box.maxX);

            case 2 -> new AABB(1.0 - box.maxX, box.minY, 1.0 - box.maxZ, 1.0 - box.minX, box.maxY, 1.0 - box.minZ);

            case 3 -> new AABB(box.minZ, box.minY, 1.0 - box.maxX, box.maxZ, box.maxY, 1.0 - box.minX);

            default -> box;
        };
    }

    private static AABB rotateBoxX(AABB box, int quarterTurns) {
        return switch (quarterTurns) {
            case 1 -> new AABB(box.minX, 1.0 - box.maxZ, box.minY, box.maxX, 1.0 - box.minZ, box.maxY);

            case 3 -> new AABB(box.minX, box.minZ, 1.0 - box.maxY, box.maxX, box.maxZ, 1.0 - box.minY);

            default -> box;
        };
    }

    public record HorizontalShapeSet(VoxelShape north, VoxelShape east, VoxelShape south, VoxelShape west) {
        public VoxelShape get(Direction direction) {
            return switch (direction) {
                case NORTH -> north;
                case EAST -> east;
                case SOUTH -> south;
                case WEST -> west;
                default -> north;
            };
        }
    }


    public static void registerDirectional(ResourceLocation id, VoxelShape north) {
        registerDirectional(id, north, rotateNorthToEast(north), rotateNorthToSouth(north), rotateNorthToWest(north), rotateNorthToUp(north), rotateNorthToDown(north));
    }

    public static void registerDirectional(ResourceLocation id, VoxelShape north, VoxelShape east, VoxelShape south, VoxelShape west, VoxelShape up, VoxelShape down) {
        if (DIRECTIONAL_SHAPES.putIfAbsent(id, new DirectionalShapeSet(north, east, south, west, up, down)) !=null) {
            throw new IllegalStateException("Duplicate SF Deco directional shape: " + id);
        }
    }

    public static DirectionalShapeSet getDirectionalShape(ResourceLocation id) {
        DirectionalShapeSet shapes = DIRECTIONAL_SHAPES.get(id);
        if (shapes == null){
            throw new IllegalStateException("Unknown SF Deco directional shape: " + id);
        }
        return shapes;
    }

    private static VoxelShape rotateNorthToUp(VoxelShape shape) {
        return transformShapeX(shape, 1);
    }

    private static VoxelShape rotateNorthToDown(VoxelShape shape) {
        return transformShapeX(shape, 3);
    }

    public record DirectionalShapeSet(VoxelShape north, VoxelShape east, VoxelShape south, VoxelShape west, VoxelShape up, VoxelShape down) {
        public VoxelShape get(Direction direction) {
            return switch (direction) {
                case NORTH -> north;
                case EAST -> east;
                case SOUTH -> south;
                case WEST -> west;
                case UP -> up;
                case DOWN -> down;
            };
        }
    }
}
