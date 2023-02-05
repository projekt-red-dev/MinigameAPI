package net.projektcontingency.minigameapi;

import org.bukkit.plugin.java.JavaPlugin;

public final class MinigameAPI extends JavaPlugin {

    private static MinigameAPI instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MinigameAPI getInstance() {
        return instance;
    }
}
