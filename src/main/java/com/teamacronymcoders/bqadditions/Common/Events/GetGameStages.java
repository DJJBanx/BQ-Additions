package com.teamacronymcoders.bqadditions.Common.Events;

import betterquesting.api.questing.IQuest;
import betterquesting.api.questing.tasks.ITask;
import betterquesting.questing.QuestDatabase;
import com.teamacronymcoders.bqadditions.Common.Tasks.GameStages.GetGameStage.TaskGetGameStage;
import net.darkhax.gamestages.event.GameStageEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GetGameStages {
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onGameStageAdded(GameStageEvent.Added event){
        EntityPlayer player = event.getPlayer();

        if (player == null)
            return;

        for (Map.Entry<TaskGetGameStage, IQuest> set : getGameStages(player.getUniqueID()).entrySet()){
            set.getKey().getGameStage(player);
        }
    }

    HashMap<TaskGetGameStage, IQuest> getGameStages(UUID uuid){
        HashMap<TaskGetGameStage, IQuest> map = new HashMap<TaskGetGameStage, IQuest>();
        for (IQuest quest : QuestDatabase.INSTANCE.getAllValues()){
            for (ITask task : quest.getTasks().getAllValues()){
                if (task instanceof TaskGetGameStage && !task.isComplete(uuid)){
                    map.put((TaskGetGameStage) task, quest);
                }
            }
        }
        return map;
    }
}
