package main.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class vanishCommand implements CommandExecutor {

    ArrayList<Player> invisible_list = new ArrayList<>();

    Main plugin;

    public vanishCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (invisible_list.contains(player)){
                for (Player people : Bukkit.getOnlinePlayers()) {
                    people.showPlayer(plugin, player);
                }
                invisible_list.remove(player);
                player.sendMessage(ChatColor.GREEN + "Je bent nu zichtbaar voor spelers op de server.");
            }else if (!invisible_list.contains(player)){
                for (Player people : Bukkit.getOnlinePlayers()){
                    people.hidePlayer(plugin, player);
                }
                invisible_list.add(player);
                player.sendMessage(ChatColor.RED + "Je bent nu NIET zichbaar voor spelers op de server");
            }

        }

        return true;
    }
}
