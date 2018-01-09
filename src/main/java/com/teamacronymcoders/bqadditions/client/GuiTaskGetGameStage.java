package com.teamacronymcoders.bqadditions.client;

import betterquesting.api.client.gui.GuiElement;
import betterquesting.api.client.gui.misc.IGuiEmbedded;
import betterquesting.client.themes.ThemeRegistry;
import com.teamacronymcoders.bqadditions.common.tasks.gamestages.getgamestage.TaskGetGameStage;
import net.minecraft.client.Minecraft;

public class GuiTaskGetGameStage extends GuiElement implements IGuiEmbedded {

    private Minecraft mc;
    private String targetGameStage;

    private int posX = 0;
    private int posY = 0;
    private int sizeX = 0;

    public GuiTaskGetGameStage(TaskGetGameStage task, int posX, int posY, int sizeX, int sizeY) {
        this.mc = Minecraft.getMinecraft();
        this.targetGameStage = task.targetGameStage;
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sizeX;
    }

    @Override
    public void drawBackground(int i, int i1, float v) {
        mc.fontRenderer.drawString("bqadditions.task.getgamestage",
                posX + sizeX / 2 - mc.fontRenderer.getStringWidth("bqadditions.task.getgamestage") / 2, posY,
                ThemeRegistry.INSTANCE.getCurrentTheme().getTextColor());
        String name = "GameStage: " + targetGameStage;
        mc.fontRenderer.drawString(name, posX + sizeX / 2 - mc.fontRenderer.getStringWidth(name) / 2, posY + 20,
                ThemeRegistry.INSTANCE.getCurrentTheme().getTextColor());
    }

    @Override
    public void drawForeground(int i, int i1, float v) {
        // TODO Auto-Generated Method
    }

    @Override
    public void onMouseClick(int i, int i1, int i2) {
        // TODO Auto-Generated Method
    }

    @Override
    public void onMouseScroll(int i, int i1, int i2) {
        // TODO Auto-Generated Method
    }

    @Override
    public void onKeyTyped(char c, int i) {
        // TODO Auto-Generated Method
    }
}
