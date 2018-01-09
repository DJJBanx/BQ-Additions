package com.teamacronymcoders.bqadditions.common.tasks.gamestages.getgamestage;

import betterquesting.api.enums.EnumSaveType;
import betterquesting.api.misc.IFactory;
import com.google.gson.JsonObject;
import com.teamacronymcoders.bqadditions.BQAdditions;
import net.minecraft.util.ResourceLocation;

public class TaskGetGameStageFactory implements IFactory<TaskGetGameStage> {

    @Override
    public ResourceLocation getRegistryName() {
        return new ResourceLocation(BQAdditions.MODID, "getgamestage");
    }

    @Override
    public TaskGetGameStage createNew() {
        return new TaskGetGameStage();
    }

    @Override
    public TaskGetGameStage loadFromJson(JsonObject json) {
        TaskGetGameStage task = new TaskGetGameStage();
        task.readFromJson(json, EnumSaveType.CONFIG);
        return task;
    }
}
