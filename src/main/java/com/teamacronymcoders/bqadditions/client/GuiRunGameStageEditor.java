package com.teamacronymcoders.bqadditions.client;

import betterquesting.api.client.gui.GuiScreenThemed;
import betterquesting.api.client.gui.controls.GuiBigTextField;
import betterquesting.api.client.gui.misc.IVolatileScreen;
import com.teamacronymcoders.bqadditions.common.tasks.gamestages.getgamestage.TaskGetGameStage;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.io.IOException;

public class GuiRunGameStageEditor extends GuiScreenThemed implements IVolatileScreen{
    TaskGetGameStage task;
    private GuiTextField nameField;

    public GuiRunGameStageEditor(GuiScreen parent, TaskGetGameStage task) {
        super(parent, "bqadditions.title.edit_gamestage");
        this.task = task;
    }

    @Override
    public void initGui() {
        super.initGui();
        Keyboard.enableRepeatEvents(true);
        int i = (this.width - this.sizeX) / 2;
        int j = (this.height - this.sizeY) / 2;
        this.fontRenderer.drawString("GameStage Identifier: ", i + 50, j + 34, 0);
        this.nameField = new GuiBigTextField(this.fontRenderer, i + 82, j + 34, 103, 12);
        this.nameField.setMaxStringLength(30);
        this.nameField.setCanLoseFocus(false);
        this.nameField.setFocused(true);
        String txt = task.targetGameStage;
        if(txt != null)
            nameField.setText(txt);
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        this.task.targetGameStage = nameField.getText();
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        GlStateManager.disableLighting();
        GlStateManager.disableBlend();
        this.nameField.drawTextBox();
    }

    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        int i = (this.width - this.sizeX) / 2;
        int j = (this.height - this.sizeY) / 2;
        Gui.drawRect(i + 62, j + 24, 0, 0, Color.BLACK.getRGB());
    }

    @Override
    protected void mouseClicked(int mx, int my, int click) throws IOException {
        super.mouseClicked(mx, my, click);

        nameField.mouseClicked(mx, my, click);
    }

    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    @Override
    protected void keyTyped(char character, int keyCode) throws IOException {
        super.keyTyped(character, keyCode);
        nameField.textboxKeyTyped(character, keyCode);
    }
}
