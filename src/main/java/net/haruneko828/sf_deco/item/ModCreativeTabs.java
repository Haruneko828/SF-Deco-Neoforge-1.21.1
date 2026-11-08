package net.haruneko828.sf_deco.item;

import net.haruneko828.sf_deco.SF_Deco;
import net.haruneko828.sf_deco.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SF_Deco.MOD_ID);

    public static final Supplier<CreativeModeTab> SF_BASE_BLOCKS_TAB = CREATIVE_MODE_TAB.register("sf_base_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.CONCRETE_WALL_A.get()))
                    .title(Component.translatable("creativetab.sf_deco.base_blocks"))
                    .displayItems((parameters, output) -> {

                        output.accept(ModBlocks.CONCRETE_WALL_A);
                        output.accept(ModBlocks.CONCRETE_WALL_B);
                        output.accept(ModBlocks.CONCRETE_WALL_C);
                        output.accept(ModBlocks.CONCRETE_WALL_D);
                        output.accept(ModBlocks.CONCRETE_WALL_E);
                        output.accept(ModBlocks.CONCRETE_WALL_F);
                        output.accept(ModBlocks.CONCRETE_WALL_G);
                        output.accept(ModBlocks.CONCRETE_WALL_H);
                        output.accept(ModBlocks.CONCRETE_WALL_I);
                        output.accept(ModBlocks.CONCRETE_WALL_J);
                        output.accept(ModBlocks.CONCRETE_FLOOR_A);
                        output.accept(ModBlocks.CONCRETE_FLOOR_B);
                        output.accept(ModBlocks.BASE_CONCRETE_A);
                        output.accept(ModBlocks.EXPOSED_CONCRETE_A);
                        output.accept(ModBlocks.EXPOSED_CONCRETE_B);
                        output.accept(ModBlocks.EXPOSED_CONCRETE_C);
                        output.accept(ModBlocks.EXPOSED_CONCRETE_D);

                    }).build());

    public static final Supplier<CreativeModeTab> SF_BLOCKS_TAB = CREATIVE_MODE_TAB.register("sf_blocks_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(SF_Deco.MOD_ID, "sf_base_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.CONCRETE_WALL_A.get()))
                    .title(Component.translatable("creativetab.sf_deco.sf_blocks"))
                    .displayItems((parameters, output) -> {

                        output.accept(ModBlocks.FACTORY_METAL_FLOOR_A_CTM_A);
                        output.accept(ModBlocks.FACTORY_METAL_FLOOR_A_CTM_B);
                        output.accept(ModBlocks.FACTORY_METAL_FLOOR_A);

                    }).build());

    public static final Supplier<CreativeModeTab> SF_PROPS_TAB = CREATIVE_MODE_TAB.register("sf_props_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(SF_Deco.MOD_ID, "sf_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.ELECTRIC_BOX_A.get()))
                    .title(Component.translatable("creativetab.sf_deco.sf_props"))
                    .displayItems((parameters, output) -> {

                        output.accept(ModBlocks.ELECTRIC_BOX_A);
                        output.accept(ModBlocks.ELECTRIC_BOX_B);
                        output.accept(ModBlocks.ELECTRIC_BOX_C);
                        output.accept(ModBlocks.ELECTRIC_BOX_D);
                        output.accept(ModBlocks.ELECTRIC_BOX_F);
                        output.accept(ModBlocks.ELECTRIC_BOX_G);
                        output.accept(ModBlocks.ELECTRIC_BOX_H);
                        output.accept(ModBlocks.WALL_VENT);
                        output.accept(ModBlocks.MODERN_LIGHT_A);
                        output.accept(ModBlocks.MODERN_LIGHT_B);
                        output.accept(ModBlocks.WATER_COOLER);
                        output.accept(ModBlocks.OFFICE_CHAIR_A_WHITE);
                        output.accept(ModBlocks.OFFICE_CHAIR_A_BLACK);
                        output.accept(ModBlocks.OFFICE_PLANT_A);
                        output.accept(ModBlocks.OFFICE_PLANT_B);
                        output.accept(ModBlocks.OFFICE_PLANT_C);
                        output.accept(ModBlocks.OFFICE_PLANT_D);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
