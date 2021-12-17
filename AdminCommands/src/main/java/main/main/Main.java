package main.main;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("fly").setExecutor(new fly());
        getCommand("vanish").setExecutor(new vanishCommand(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
