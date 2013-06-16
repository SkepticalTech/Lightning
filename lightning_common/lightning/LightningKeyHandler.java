package lightning;

import java.util.EnumSet;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class LightningKeyHandler extends KeyHandler {
    private Minecraft mcinstance;
    static KeyBinding[] keyBinds = {
        new KeyBinding("Global Chat", Keyboard.KEY_G),
        new KeyBinding("Join Match", Keyboard.KEY_J)
    };

    public LightningKeyHandler(Minecraft mc) {
        // the first value is an array of KeyBindings, the second is whether or
        // not the call
        // keyDown should repeat as long as the key is down
        super(keyBinds, new boolean[] { false, false});
        mcinstance = mc;
    }

    @Override
    public String getLabel() {
        return "lightningkeybindings";
    }

    @Override
    public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
        if(mcinstance.currentScreen == null && tickEnd){
            if(kb == keyBinds[0]){ //Global chat
                GuiChat gc = new GuiChat("/g ");
                mcinstance.displayGuiScreen(gc);
            }
            else if(kb == keyBinds[1]){ //Join match
                mcinstance.thePlayer.sendChatMessage("join");
            }
            
        }
    }

    @Override
    public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
    }

    @Override
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.CLIENT);
    }
}
