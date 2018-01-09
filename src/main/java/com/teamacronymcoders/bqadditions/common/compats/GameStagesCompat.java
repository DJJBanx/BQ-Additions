package com.teamacronymcoders.bqadditions.common.compats;

import betterquesting.questing.tasks.TaskRegistry;
import com.teamacronymcoders.bqadditions.common.event.GetGameStages;
import com.teamacronymcoders.bqadditions.common.tasks.gamestages.getgamestage.TaskGetGameStageFactory;
import net.minecraftforge.common.MinecraftForge;

public class GameStagesCompat {

    public static GetGameStages getGameStages;

    public static void setup() {
        getGameStages = new GetGameStages();
        MinecraftForge.EVENT_BUS.register(getGameStages);
        TaskRegistry.INSTANCE.registerTask(new TaskGetGameStageFactory());
    }
}
