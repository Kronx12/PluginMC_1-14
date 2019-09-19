package fr.kronx12.Exercice_2;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new EventClass(this), this);
		Bukkit.getPluginCommand("toggle_ore").setExecutor(new CommandClass(this));
	}
}