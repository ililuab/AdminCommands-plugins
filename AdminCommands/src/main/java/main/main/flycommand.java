package main.main;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class flycommand {
}

class fly implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("fly")) {
                if(!p.hasPermission("Fly.User")) {
                    p.sendMessage("§7Je hebt geen permissies.");
                    return true;
                } else {
                    if(p.getAllowFlight() == true) {
                        p.setAllowFlight(false);
                        p.sendMessage(ChatColor.RED + p.getName()+ " " +"Fly is uitgezet");
                        return true;
                    }
                    if(p.getAllowFlight() == false) {
                        p.setAllowFlight(true);
                        p.sendMessage(ChatColor.GREEN + p.getName()+ " " +"Fly is aangezet");
                        return true;
                    }

                }
            }
        }
        return false;
    }

}
