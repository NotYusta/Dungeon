package xyz.raidpvp.dungeon.boss;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class Part2 implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Enderman && e.getDamager() instanceof Player) {
            if (e.getEntity().hasMetadata("Ender King")) {
                Player player = (Player) e.getDamager();

                // Ability #1: Block Attack

                Random rand = new Random();
                int random = rand.nextInt(100);
                if (random < 5) { // 5 percent chance
                    e.setCancelled(true);
                    player.playSound(player.getLocation(), Sound.valueOf("ANVIL_LAND"), 10, 10);
                    player.sendMessage("§c§lYour attack was blocked!");
                }

                // Ability #2: SpawnMinion(s)

                int random2 = rand.nextInt(100);
                if (random2 < 15) {
                    ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
                    helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,4);
                    ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                    chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,4);
                    ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
                    leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,4);
                    ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
                    boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,4);
                    e.setCancelled(true);
                    Zombie minion1 = (Zombie)e.getDamager().getWorld().spawnEntity(e.getDamager().getLocation().add(0.5, 0, 0.5), EntityType.ZOMBIE);
                    minion1.isBaby();
                    minion1.setCustomName("§7Ender §dKing's Minion");
                    minion1.setCustomNameVisible(true);
                    minion1.setTarget(player);
                    minion1.getEquipment().setBoots(boots);
                    minion1.getEquipment().setHelmet(helmet);
                    minion1.getEquipment().setChestplate(chestplate);
                    minion1.getEquipment().setLeggings(leggings);
                }
                // Ability #3: SpawnWarrior(s)
            }
        }
    }
}
