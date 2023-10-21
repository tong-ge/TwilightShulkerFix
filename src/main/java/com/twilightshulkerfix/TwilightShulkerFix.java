package com.twilightshulkerfix;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid="twilightshulkerfix",useMetadata = true)
public class TwilightShulkerFix {
    public static Logger logger;
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger=event.getModLog();
    }
}
