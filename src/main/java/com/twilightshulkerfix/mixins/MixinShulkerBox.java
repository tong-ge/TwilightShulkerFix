package com.twilightshulkerfix.mixins;

import com.twilightshulkerfix.TwilightShulkerFix;
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

@Mixin(value = BlockShulkerBox.class)
public abstract class MixinShulkerBox extends BlockContainer {
    protected MixinShulkerBox(Material materialIn) {
        super(materialIn);
    }

    @Inject(method = "getBlockFaceShape",at = @At("HEAD"),cancellable = true)
    private void pre_getBlockFaceShape(IBlockAccess worldIn,
                                       IBlockState state,
                                       BlockPos pos,
                                       EnumFacing face,
                                       CallbackInfoReturnable<BlockFaceShape> cir)
    {
        //System.out.println("INJECT SUCCESS");
        if(worldIn.getTileEntity(pos) == null)
        {
            TwilightShulkerFix.logger.info("SHULKER BOX NOT INITIALIZED");
            cir.setReturnValue(BlockFaceShape.UNDEFINED);
        }
    }
}
