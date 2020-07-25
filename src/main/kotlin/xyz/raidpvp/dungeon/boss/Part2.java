package xyz.raidpvp.dungeon.boss;

import org.bukkit.Sound;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Random;

public class Part2 implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Enderman && e.getDamager() instanceof Player){
            if(e.getEntity().hasMetadata("EnderBoss")) {
                Player player = (Player)e.getDamager();

                // Ability #1: Block Attack

                Random rand = new Random();
                int random = rand.nextInt(100);
                if(random<5){ // 5 percent chance
                    e.setCancelled(true);
                    player.playSound(player.getLocation(), Sound.valueOf("ANVIL_LAND"),10,10);
                    player.sendMessage("§c§lYour attack was blocked!");
                }

                // Ability #2: SpawnMinion(s)

                int random2 = rand.nextInt(100);
                if (random2<15) {
                    e.setCancelled(true);
                    spawnMinion(random2);
                }
            }
        }
    }

    private void spawnMinion(int amount){
        //Minion spawning logic
        // TODO("Finish spawning logic)
    }
}
