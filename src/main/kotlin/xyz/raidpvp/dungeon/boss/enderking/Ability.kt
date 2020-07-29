package xyz.raidpvp.dungeon.boss.enderking

import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.*
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import java.util.*

class Ability : Listener {
    
    @EventHandler
    fun onDamage(e: EntityDamageByEntityEvent) {
        if (e.entity is Enderman && e.damager is Player) {
            if (e.entity.hasMetadata("Ender King")) {
                val player = e.damager as Player
                val endermans = e.entity as Enderman

                // Ability #1: Block Attack

                val rand = Random()
                val random = rand.nextInt(100)
                if (random < 5) {
                    e.isCancelled = true
                    player.playSound(player.location, Sound.valueOf("ANVIL_LAND"), 10f, 10f)
                    player.sendMessage("§c§lYour attack was blocked!")
                    player.sendTitle("§4§lBlocked", "§cAttack has been blocked", 1, 5 ,1)
                }

                // Ability #2: SpawnMinion(s)
                
                val random2 = rand.nextInt(100)
                if (random2 < 5) {
                    val helmet = ItemStack(Material.DIAMOND_HELMET)
                    helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
                    val chestplate = ItemStack(Material.DIAMOND_CHESTPLATE)
                    chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
                    val leggings = ItemStack(Material.DIAMOND_LEGGINGS)
                    leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
                    val boots = ItemStack(Material.DIAMOND_BOOTS)
                    boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
                    
                    val minion = e.damager.world.spawnEntity(e.damager.location.add(0.5, 0.0, 0.5), EntityType.ZOMBIE) as Zombie
                    minion.customName = "§7Ender §dKing's Minion"
                    minion.isCustomNameVisible = true
                    minion.target = player
                    minion.equipment.boots = boots
                    minion.equipment.helmet = helmet
                    minion.equipment.chestplate = chestplate
                    minion.equipment.leggings = leggings
                    minion.health = 20.0

                    val minion2 = e.damager.world.spawnEntity(e.damager.location.add(0.5, 0.0, 0.5), EntityType.ZOMBIE) as Zombie
                    minion2.customName = "§7Ender §dKing's Minion"
                    minion2.isCustomNameVisible = true
                    minion2.target = player
                    minion2.equipment.boots = boots
                    minion2.equipment.helmet = helmet
                    minion2.equipment.chestplate = chestplate
                    minion2.equipment.leggings = leggings
                    minion2.health = 20.0
                    
                    val ender_magic = e.damager.world.spawnEntity(e.damager.location.add(0.5, 0.0, 0.5), EntityType.EVOKER) as Evoker
                    ender_magic.customName = "§5§End Wizard"
                    ender_magic.isCustomNameVisible = true
                    ender_magic.target = player
                    ender_magic.health = 50.0
                    player.sendTitle("§4§lEnder Army", "§chas spawned!", 1, 5 ,1)
                }
                
                val random5 = rand.nextInt(100)
                if (random5 < 0.5) {
                    val boss = e.entity as Enderman
                    val player = e.damager as Player
                    boss.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION, 30, 5, true, true))
                    player.sendMessage("§cThe §7Ender §dKing §chas been regenerated!")
                }
                // More ability soon
            }
        }
    }
}
