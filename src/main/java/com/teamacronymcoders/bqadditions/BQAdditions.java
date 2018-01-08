package com.teamacronymcoders.bqadditions;

import betterquesting.questing.tasks.TaskRegistry;
import com.teamacronymcoders.bqadditions.common.compats.GameStages;
import com.teamacronymcoders.bqadditions.common.tasks.gamestages.getgamestage.TaskGetGameStageFactory;

import com.teamacronymcoders.bqadditions.util.BQAConfig;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = BQAdditions.MODID,
     name = BQAdditions.NAME,
     version = BQAdditions.VERSION,
     dependencies = BQAdditions.DEPS,
     acceptedMinecraftVersions = BQAdditions.MCVERS)

public class BQAdditions
{
    public static final String MODID = "bqadditions";
    public static final String NAME = "BQ-Additions";
    public static final String VERSION = "1.0.0";
    public static final String DEPS = "required:forge@[14.23.1.2586,);required-after:betterquesting;";
    public static final String MCVERS = "1.12, 1.12.1, 1.12.2";

    @Mod.Instance
    public static BQAdditions instance;
    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();
        BQAConfig.preInit(event);
        if (Loader.isModLoaded("gamestages")){
            GameStages.setup();
        }
    }


    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}
