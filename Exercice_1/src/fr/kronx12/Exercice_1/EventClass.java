package fr.kronx12.Exercice_1;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class EventClass implements Listener {
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		if (event.getBlock().getType().equals(Material.IRON_ORE)) {
			
			// Init
			Location bLoc = event.getBlock().getLocation();
			World bWorld = event.getBlock().getWorld();
			
			// Spawn
			event.setDropItems(false);
			bWorld.dropItem(bLoc.add(0.5, 0.5, 0.5), new ItemStack(Material.IRON_INGOT, 5));
			bWorld.spawnParticle(Particle.VILLAGER_HAPPY, bLoc.add(0.5, 0.5, 0.5), 10, 0.5, 0.5, 0.5);
			ExperienceOrb xp = (ExperienceOrb) bWorld.spawnEntity(bLoc.add(0.5, 0.5, 0.5), EntityType.EXPERIENCE_ORB);
			xp.setExperience(10);
		}
	}
}
