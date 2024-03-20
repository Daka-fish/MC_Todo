package net.tv.twitch.chrono_fish.todo;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TodoEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        TodoManager.setBoard(e.getPlayer());
    }
}
