package net.haruneko828.sf_deco.block;

import net.haruneko828.sf_deco.SF_Deco;
import net.haruneko828.sf_deco.block.shape.ModShapesLibrary;
import net.haruneko828.sf_deco.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SF_Deco.MOD_ID);

    //通常フルブロック
    public static final DeferredBlock<Block> CONCRETE_WALL_A = registerBlock("concrete_wall_a",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> CONCRETE_WALL_B = registerBlock("concrete_wall_b",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> CONCRETE_WALL_C = registerBlock("concrete_wall_c",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> CONCRETE_WALL_D = registerBlock("concrete_wall_d",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> CONCRETE_WALL_E = registerBlock("concrete_wall_e",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> CONCRETE_WALL_F = registerBlock("concrete_wall_f",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> CONCRETE_WALL_G = registerBlock("concrete_wall_g",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> CONCRETE_WALL_H = registerBlock("concrete_wall_h",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> CONCRETE_WALL_I = registerBlock("concrete_wall_i",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> CONCRETE_WALL_J = registerBlock("concrete_wall_j",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> CONCRETE_FLOOR_A = registerBlock("concrete_floor_a",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> CONCRETE_FLOOR_B = registerBlock("concrete_floor_b",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> BASE_CONCRETE_A = registerBlock("base_concrete_a",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> EXPOSED_CONCRETE_A = registerBlock("exposed_concrete_a",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> EXPOSED_CONCRETE_B = registerBlock("exposed_concrete_b",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> EXPOSED_CONCRETE_C = registerBlock("exposed_concrete_c",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> EXPOSED_CONCRETE_D = registerBlock("exposed_concrete_d",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));


    public static final DeferredBlock<Block> FACTORY_METAL_FLOOR_A = registerBlock("factory_metal_floor_a",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> FACTORY_METAL_FLOOR_A_CTM_A = registerBlock("factory_metal_floor_a_ctm_a",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> FACTORY_METAL_FLOOR_A_CTM_B = registerBlock("factory_metal_floor_a_ctm_b",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));


    //HorizontalPropBlock系 装飾ブロック
    public static final DeferredBlock<HorizontalPropBlock> ELECTRIC_BOX_A = registerBlock("electric_box_a",
            HorizontalPropBlock.create("electric_box_a", BlockBehaviour.Properties.of()
                            .strength(4f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.NETHERITE_BLOCK),
                    ModShapesLibrary.ELECTRIC_BOX_A));

    public static final DeferredBlock<HorizontalPropBlock> ELECTRIC_BOX_B = registerBlock("electric_box_b",
            HorizontalPropBlock.create("electric_box_b", BlockBehaviour.Properties.of()
                            .strength(4f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.NETHERITE_BLOCK),
                    ModShapesLibrary.ELECTRIC_BOX_B
            ));

    public static final DeferredBlock<HorizontalPropBlock> ELECTRIC_BOX_C = registerBlock("electric_box_c",
            HorizontalPropBlock.create("electric_box_c", BlockBehaviour.Properties.of()
                            .strength(4f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.NETHERITE_BLOCK)
                    ,ModShapesLibrary.ELECTRIC_BOX_D));

    public static final DeferredBlock<HorizontalPropBlock> ELECTRIC_BOX_D = registerBlock("electric_box_d",
            HorizontalPropBlock.create("electric_box_d", BlockBehaviour.Properties.of()
                            .strength(4f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.NETHERITE_BLOCK)
                    ,ModShapesLibrary.ELECTRIC_BOX_D));

    public static final DeferredBlock<HorizontalPropBlock> ELECTRIC_BOX_F = registerBlock("electric_box_f",
            HorizontalPropBlock.create("electric_box_f", BlockBehaviour.Properties.of()
                            .strength(4f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.NETHERITE_BLOCK)
                    ,ModShapesLibrary.ELECTRIC_BOX_D));

      public static final DeferredBlock<HorizontalPropBlock> ELECTRIC_BOX_G = registerBlock("electric_box_g",
            HorizontalPropBlock.create("electric_box_g", BlockBehaviour.Properties.of()
                            .strength(4f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.NETHERITE_BLOCK)
                    ,ModShapesLibrary.ELECTRIC_BOX_D));

      public static final DeferredBlock<HorizontalPropBlock> ELECTRIC_BOX_H = registerBlock("electric_box_h",
            HorizontalPropBlock.create("electric_box_h", BlockBehaviour.Properties.of()
                            .strength(4f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.NETHERITE_BLOCK)
                    ,ModShapesLibrary.ELECTRIC_BOX_D));


      public static final DeferredBlock<HorizontalPropBlock> WATER_COOLER = registerBlock("water_cooler",
              HorizontalPropBlock.create("water_cooler",BlockBehaviour.Properties.of()
                              .strength(4f)
                              .requiresCorrectToolForDrops()
                              .sound(SoundType.BAMBOO)
                      ,ModShapesLibrary.WATER_COOLER));

      public static final DeferredBlock<HorizontalPropBlock> OFFICE_CHAIR_A_WHITE = registerBlock("office_chair_a_white",
              HorizontalPropBlock.create("office_chair_a_white",BlockBehaviour.Properties.of()
                              .strength(4f)
                              .requiresCorrectToolForDrops()
                              .sound(SoundType.WOOD)
                      ,ModShapesLibrary.OFFICE_CHAIR_A));

      public static final DeferredBlock<HorizontalPropBlock> OFFICE_CHAIR_A_BLACK = registerBlock("office_chair_a_black",
              HorizontalPropBlock.create("office_chair_a_black",BlockBehaviour.Properties.of()
                              .strength(4f)
                              .requiresCorrectToolForDrops()
                              .sound(SoundType.WOOD)
                      ,ModShapesLibrary.OFFICE_CHAIR_A));

      public static final DeferredBlock<HorizontalPropBlock> OFFICE_PLANT_A = registerBlock("office_plant_a",
              HorizontalPropBlock.create("office_plant_a",BlockBehaviour.Properties.of()
                              .strength(4f)
                              .requiresCorrectToolForDrops()
                              .sound(SoundType.STONE)
                      ,ModShapesLibrary.OFFICE_PLANT_A));

      public static final DeferredBlock<HorizontalPropBlock> OFFICE_PLANT_B = registerBlock("office_plant_b",
              HorizontalPropBlock.create("office_plant_b",BlockBehaviour.Properties.of()
                              .strength(4f)
                              .requiresCorrectToolForDrops()
                              .sound(SoundType.STONE)
                      ,ModShapesLibrary.OFFICE_PLANT_A));

      public static final DeferredBlock<HorizontalPropBlock> OFFICE_PLANT_C = registerBlock("office_plant_c",
              HorizontalPropBlock.create("office_plant_c",BlockBehaviour.Properties.of()
                              .strength(4f)
                              .requiresCorrectToolForDrops()
                              .sound(SoundType.STONE)
                      ,ModShapesLibrary.OFFICE_PLANT_A));

      public static final DeferredBlock<HorizontalPropBlock> OFFICE_PLANT_D = registerBlock("office_plant_d",
              HorizontalPropBlock.create("office_plant_d",BlockBehaviour.Properties.of()
                              .strength(4f)
                              .requiresCorrectToolForDrops()
                              .sound(SoundType.STONE)
                      ,ModShapesLibrary.OFFICE_PLANT_B));

    //DirectionalPropBlock系 装飾ブロック
    public static final DeferredBlock<DirectionalPropBlock> MODERN_LIGHT_A = registerBlock("modern_light_a",
            DirectionalPropBlock.create("modern_light_a", BlockBehaviour.Properties.of()
                            .strength(4f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.STONE)
                            .lightLevel(state -> 14)
                    ,ModShapesLibrary.MODERN_LIGHT_A));

    public static final DeferredBlock<DirectionalPropBlock> MODERN_LIGHT_B = registerBlock("modern_light_b",
            DirectionalPropBlock.create("modern_light_b", BlockBehaviour.Properties.of()
                            .strength(4f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.STONE)
                            .lightLevel(state -> 14)
                    ,ModShapesLibrary.MODERN_LIGHT_A));

    //SurfaceMountedPropBlock系 装飾ブロック
    public static final DeferredBlock<SurfaceMountedPropBlock> WALL_VENT = registerBlock("wall_vent",
            SurfaceMountedPropBlock.create("wall_vent", BlockBehaviour.Properties.of()
                            .strength(4f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.NETHERITE_BLOCK)
                    ,ModShapesLibrary.WALL_PANEL));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
