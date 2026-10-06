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

                    }).build());

    public static final Supplier<CreativeModeTab> SF_BLOCKS_TAB = CREATIVE_MODE_TAB.register("sf_blocks_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(SF_Deco.MOD_ID, "sf_base_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.CONCRETE_WALL_A.get()))
                    .title(Component.translatable("creativetab.sf_deco.sf_blocks"))
                    .displayItems((parameters, output) -> {


                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
