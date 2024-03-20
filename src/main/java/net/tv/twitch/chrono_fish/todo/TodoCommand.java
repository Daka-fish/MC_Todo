package net.tv.twitch.chrono_fish.todo;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TodoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(command.getName().equalsIgnoreCase("todo")){
                if(args.length == 2){
                    if(args[0].equalsIgnoreCase("add")){
                        TodoManager.addTodo(args[1],player);
                    }
                    if(args[0].equalsIgnoreCase("remove")){
                        TodoManager.removeTodo(args[1],player);
                    }
                }
            }
        }
        return false;
    }
}
