package net.haruneko828.sf_deco.block.shape;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import static net.minecraft.world.level.block.Block.box;

public class ModShapesLibrary {
    private ModShapesLibrary() {
    }

    public static final VoxelShape TEST_PROP = box(2, 2, 0, 14, 14, 8);
    public static final VoxelShape BIG_SHAPE_TEST = box(0, 0, 3, 16, 25, 16);
    public static final VoxelShape ELECTRIC_BOX_A = box(4, 2, 12, 12, 12, 16);
    public static final VoxelShape ELECTRIC_BOX_D = box(1, 2, 12, 15, 14, 16);
    public static final VoxelShape WALL_PANEL = Block.box(0, 0, 15, 16, 16, 16);
    public static final VoxelShape MODERN_LIGHT_A = box(5, 5, 14, 11, 11, 16);
    public static final VoxelShape OFFICE_PLANT_A = box(4, 0, 4, 12, 10, 12);
    public static final VoxelShape OFFICE_PLANT_B = box(0, 0, 5, 16, 9, 11);

    public static final VoxelShape ELECTRIC_BOX_B = Shapes.or(
            box(8.25, 2, 12, 16.25, 12, 16),
            box(-0.25, 2, 12, 7.75, 12, 16));

    public static final VoxelShape WATER_COOLER = Shapes.or(Shapes.or(
                    box(3.5, 0, 7, 12.5, 20, 16),
                    box(5, 20, 8.5, 11, 21, 14.5)),
                    box(4, 21, 7.5, 12, 30, 15.5));

    public static final VoxelShape OFFICE_CHAIR_A = Shapes.or(
            Block.box(2, 10, 12.75, 14, 19, 14.75),
            Block.box(0.5, 11.5, 2, 2.5, 12.5, 14),
            Block.box(13.5, 11.5, 2, 15.5, 12.5, 14),
            Block.box(2, 5.5, 2, 14, 8.5, 14),
            Block.box(7, 2, 7, 9, 6.5, 9),
            Block.box(2.5, 0, 2.5, 13.5, 2, 13.5)
    );
}
