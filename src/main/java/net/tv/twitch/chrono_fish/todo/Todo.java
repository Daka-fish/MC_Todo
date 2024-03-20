package net.tv.twitch.chrono_fish.todo;

import org.bukkit.plugin.java.JavaPlugin;

public final class Todo extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new TodoEvent(),this);
        getCommand("todo").setExecutor(new TodoCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
