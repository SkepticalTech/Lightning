package lightning;

import lightning.lib.Reference;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class Lightning {
    private LightningKeyHandler lkeyhandler;

    @Init
    public void load(FMLInitializationEvent event) {
        // Get the Minecraft instance
        lkeyhandler = new LightningKeyHandler(FMLClientHandler.instance()
                .getClient());
        KeyBindingRegistry.registerKeyBinding(lkeyhandler);
    }
}
