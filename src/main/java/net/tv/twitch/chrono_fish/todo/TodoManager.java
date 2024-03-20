package net.tv.twitch.chrono_fish.todo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class TodoManager {
    private static Scoreboard board;
    private static Objective obj;

    public static void setBoard(Player player){
        board = Bukkit.getScoreboardManager().getNewScoreboard();
        obj = board.registerNewObjective("todo","dummy","Todo");
        obj.setDisplayName(ChatColor.BOLD+"==本日のタスク==");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score = obj.getScore(" ");
        score.setScore(0);

        player.setScoreboard(board);
    }

    public static void addTodo(String str, Player p){
        Score score = obj.getScore(str);
        if(score.isScoreSet()){
            p.sendMessage(ChatColor.RED+"そのタスクは既に存在します");
            return;
        }else{
            Score completed = obj.getScore(ChatColor.GREEN+"完了しました！");
            if(completed.isScoreSet()) obj.getScoreboard().resetScores(completed.getEntry());
            score.setScore(-1);
        }
        removeEmpty();
        p.setScoreboard(board);
    }

    public static void removeTodo(String str,Player p){
        Score score = obj.getScore(str);
        if(score.isScoreSet()){
            obj.getScoreboard().resetScores(str);
            if(obj.getScoreboard().getEntries().isEmpty()){
                Score completed = obj.getScore(ChatColor.GREEN+"完了しました！");
                completed.setScore(0);
            }
        }else{
            p.sendMessage(ChatColor.RED+"そのタスクは存在しません");
            return;
        }
    }

    public static void removeEmpty(){
        Score score = obj.getScore(" ");
        if(score.isScoreSet()){
            obj.getScoreboard().resetScores(" ");
        }
    }

}
