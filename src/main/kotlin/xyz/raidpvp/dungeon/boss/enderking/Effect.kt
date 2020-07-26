package xyz.raidpvp.dungeon.boss.enderking

import org.bukkit.Effect
import org.bukkit.Material
import org.bukkit.entity.Enderman
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.plugin.java.JavaPlugin

class Effect : JavaPlugin(), Listener {

    @EventHandler
    fun playerDamage(e: EntityDamageByEntityEvent) {
        if (e.entity is Enderman && e.damager is Player) {
            if (e.entity.hasMetadata("Ender King")) {
                val p = e.damager as Player
                val c = e.entity as Enderman
                p.location.world.playEffect(c.location, Effect.ZOMBIE_DESTROY_DOOR, Material.FIRE)

                @EventHandler
                fun entityDamage(e: EntityDamageByEntityEvent) {
                    if (e.entity is Player && e.damager is Enderman) {
                        if (e.damager.hasMetadata("Ender King")) {
                            val a = e.damager as Enderman
                            val b = e.entity as Player
                            a.location.world.playEffect(b.location, Effect.POTION_BREAK, Material.EMERALD)
                        }
                    }
                }
            }
        }
    }
}