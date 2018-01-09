package com.teamacronymcoders.bqadditions.common.tasks.gamestages.grantgamestage;

import betterquesting.api.enums.EnumSaveType;
import betterquesting.api.misc.IFactory;
import com.google.gson.JsonObject;
import com.teamacronymcoders.bqadditions.BQAdditions;
import net.minecraft.util.ResourceLocation;

public class RewardGiveGameStageFactory implements IFactory<RewardGiveGameStage> {

    public static final RewardGiveGameStageFactory INSTANCE = new RewardGiveGameStageFactory();

    @Override
    public ResourceLocation getRegistryName() {
        return new ResourceLocation(BQAdditions.MODID, "gamestage");
    }

    @Override
    public RewardGiveGameStage createNew() {
        return new RewardGiveGameStage();
    }

    @Override
    public RewardGiveGameStage loadFromJson(JsonObject jsonObject) {
        RewardGiveGameStage reward = new RewardGiveGameStage();
        reward.readFromJson(jsonObject, EnumSaveType.CONFIG);
        return reward;
    }
}
