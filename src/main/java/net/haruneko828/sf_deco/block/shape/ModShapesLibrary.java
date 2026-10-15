package net.haruneko828.sf_deco.block.shape;

import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import static net.minecraft.world.level.block.Block.box;

public class ModShapesLibrary {
    private ModShapesLibrary() {
    }

    public static final VoxelShape TEST_PROP = box(2, 2, 0, 14, 14, 8);
    public static final VoxelShape ELECTRIC_BOX_A = box(4, 2, 12, 12, 12, 16);
    public static final VoxelShape ELECTRIC_BOX_D = box(1, 2, 12, 15, 14, 16);
    public static final VoxelShape MODERN_LIGHT_A = box(5, 5, 14, 11, 11, 16);

    public static final VoxelShape ELECTRIC_BOX_B = Shapes.or(
            box(8.25, 2, 12, 16.25, 12, 16),
            box(-0.25, 2, 12, 7.75, 12, 16));

}
