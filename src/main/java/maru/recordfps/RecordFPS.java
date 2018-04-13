package maru.recordfps;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = RecordFPS.MODID, version = RecordFPS.VERSION)
public class RecordFPS
{
    public static final String MODID = "recordfps";
    public static final String VERSION = "1.0.3";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        FMLCommonHandler.instance().bus().register(new OTickEvent());
    }
}
