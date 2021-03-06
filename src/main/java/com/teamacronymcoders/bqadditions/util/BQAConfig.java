package com.teamacronymcoders.bqadditions.util;

import com.teamacronymcoders.bqadditions.BQAdditions;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class BQAConfig {
    public static void preInit(FMLPreInitializationEvent event) {
    }

    @Config(modid = BQAdditions.MODID)
    public static class BQAConfigs {
        public static Modules modules;

        public static class Modules {
            @Comment("Enable GameStages Module?")
            public static boolean GameStages = true;
        }
    }
}
