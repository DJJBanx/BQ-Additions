package com.teamacronymcoders.bqadditions.common.tasks.gamestages.getgamestage;

import betterquesting.api.client.gui.misc.IGuiEmbedded;
import betterquesting.api.enums.EnumSaveType;
import betterquesting.api.jdoc.IJsonDoc;
import betterquesting.api.questing.IQuest;
import betterquesting.api.questing.tasks.ITask;
import betterquesting.api.utils.JsonHelper;
import com.google.gson.JsonObject;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.UUID;

import static net.darkhax.gamestages.capabilities.PlayerDataHandler.getStageData;

public class TaskGetGameStage implements ITask {
    private ArrayList<UUID> completeUsers = new ArrayList<UUID>();
    public String targetGameStage = "test";

    @Override
    public String getUnlocalisedName() {
        return "bqadditions.task.getgamestage";
    }

    public void getGameStage(@Nonnull EntityPlayer player) {
        if (!isComplete(player.getUniqueID())) {
            if (getStageData(player).hasUnlockedStage(targetGameStage)) {
                this.setComplete(player.getUniqueID());
            }
        }
    }

    @Override
    public void readFromJson(JsonObject json, EnumSaveType type) {
        targetGameStage = JsonHelper.GetString(json, "name", "test");
    }

    @Override
    public JsonObject writeToJson(JsonObject json, EnumSaveType type) {
        json.addProperty("name", targetGameStage);
        return json;
    }

    @Override
    public void detect(EntityPlayer arg0, IQuest arg1) {
    }

    @Override
    public IJsonDoc getDocumentation() {
        return null;
    }

    @Override
    public ResourceLocation getFactoryID() {
        return null;
    }

    @Nullable
    @Override
    public GuiScreen getTaskEditor(GuiScreen guiScreen, IQuest iQuest) {
        return null;
    }

    @Override
    public IGuiEmbedded getTaskGui(int i, int i1, int i2, int i3, IQuest iQuest) {
        return null;
    }

    @Override
    public boolean isComplete(UUID uuid) {
        return completeUsers.contains(uuid);
    }

    @Override
    public void resetAll() {
        completeUsers.clear();
    }

    @Override
    public void resetUser(UUID uuid) {
        completeUsers.remove(uuid);
    }

    @Override
    public void setComplete(UUID uuid) {
        completeUsers.add(uuid);
    }

    @Override
    public void update(EntityPlayer entityPlayer, IQuest iQuest) {
    }
}
