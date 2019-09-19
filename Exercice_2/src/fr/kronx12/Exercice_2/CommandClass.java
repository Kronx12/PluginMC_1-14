package fr.kronx12.Exercice_2;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandClass implements CommandExecutor {
	
	private JavaPlugin plugin;
	
	public CommandClass(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			if (cmd.getName().equalsIgnoreCase("toggle_ore")) {
				if (plugin.getConfig().get("status") != null) {
					if (plugin.getConfig().getBoolean("status")) {
						plugin.getConfig().set("status", false);
						plugin.saveConfig();
						((Player) sender).sendMessage(ChatColor.GOLD + "Auto-Smelt Activate : " + ChatColor.RED + "false");
					} else {
						plugin.getConfig().set("status", true);
						plugin.saveConfig();
						((Player) sender).sendMessage(ChatColor.GOLD + "Auto-Smelt Activate : " + ChatColor.GREEN + "true");
					}
				} else {
					plugin.getConfig().set("status", true);
					plugin.saveConfig();
					((Player) sender).sendMessage(ChatColor.GOLD + "Auto-Smelt Activate : " + ChatColor.GREEN + "true");
				}
				return true;
			}
		}
		return false;
	}

}
