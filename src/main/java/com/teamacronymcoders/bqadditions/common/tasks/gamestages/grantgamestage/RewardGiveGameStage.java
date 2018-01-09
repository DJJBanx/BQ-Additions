package com.teamacronymcoders.bqadditions.common.tasks.gamestages.grantgamestage;

import betterquesting.api.client.gui.misc.IGuiEmbedded;
import betterquesting.api.enums.EnumSaveType;
import betterquesting.api.jdoc.IJsonDoc;
import betterquesting.api.questing.IQuest;
import betterquesting.api.questing.rewards.IReward;
import com.google.gson.JsonObject;
import net.darkhax.gamestages.GameStages;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class RewardGiveGameStage implements IReward {

    public ArrayList<GameStages> stages = new ArrayList<GameStages>();

    @Override
    public String getUnlocalisedName() {
        return "bqadditions.reward.gamestage";
    }

    @Override
    public ResourceLocation getFactoryID() {
        return RewardGiveGameStageFactory.INSTANCE.getRegistryName();
    }

    @Override
    public boolean canClaim(EntityPlayer entityPlayer, IQuest iQuest) {
        return true;
    }

    @Override
    public void claimReward(EntityPlayer entityPlayer, IQuest iQuest) {

    }

    @Override
    public IJsonDoc getDocumentation() {
        return null;
    }

    @Override
    public IGuiEmbedded getRewardGui(int i, int i1, int i2, int i3, IQuest iQuest) {
        return null;
    }

    @Nullable
    @Override
    public GuiScreen getRewardEditor(GuiScreen guiScreen, IQuest iQuest) {
        return null;
    }

    @Override
    public JsonObject writeToJson(JsonObject jsonObject, EnumSaveType enumSaveType) {
        return null;
    }

    @Override
    public void readFromJson(JsonObject jsonObject, EnumSaveType enumSaveType) {

    }
}
