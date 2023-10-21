package com.twilightshulkerfix.mixins;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BlockShulkerBox.class,remap = true)
public abstract class MixinShulkerBox extends BlockContainer {
    protected MixinShulkerBox(Material materialIn) {
        super(materialIn);
    }

    @Inject(method = "getBlockFaceShape",at = @At("HEAD"))
    private void pre_getBlockFaceShape(CallbackInfoReturnable<BlockFaceShape> cir,IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {}
}
