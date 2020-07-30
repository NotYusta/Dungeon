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

                    val minion = player.world.spawnEntity(e.damager.location.add(0.5, 0.0, 0.5), EntityType.ZOMBIE) as Zombie
                    minion.customName = "§7Ender §dKing's Minion"
                    minion.isCustomNameVisible = true
                    minion.target = player
                    minion.equipment.boots = boots
                    minion.equipment.helmet = helmet
                    minion.equipment.chestplate = chestplate
                    minion.equipment.leggings = leggings
                    minion.health = 20.0

                    val minion2 = player.world.spawnEntity(e.damager.location.add(0.5, 0.0, 0.5), EntityType.ZOMBIE) as Zombie
                    minion2.customName = "§7Ender §dKing's Minion"
                    minion2.isCustomNameVisible = true
                    minion2.target = player
                    minion2.equipment.boots = boots
                    minion2.equipment.helmet = helmet
                    minion2.equipment.chestplate = chestplate
                    minion2.equipment.leggings = leggings
                    minion2.health = 20.0
                    
                    val ender_magic = player.world.spawnEntity(e.damager.location.add(0.5, 0.0, 0.5), EntityType.EVOKER) as Evoker
                    ender_magic.customName = "§5§End Wizard"
                    ender_magic.isCustomNameVisible = true
                    ender_magic.target = player
                    ender_magic.health = 50.0
                    player.sendTitle("§4§lEnder Army", "§chas spawned!", 1, 5 ,1)
                    player.location.world.playSound(player.location, Sound.ENTITY_ENDERDRAGON_GROWL, 1.0f, 1.0f)
                }

                // Ability #3: Regenerate (0.5%)
                
                val random5 = rand.nextInt(100)
                if (random5 < 0.5) {
                    endermans.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION, 30, 5, true, false))
                    player.sendMessage("§cThe §7Ender §dKing §chas been regenerated!")
                    player.sendTitle("§4§lEnder King", "§chas regenerated!", 1, 5, 1)
                    player.location.world.playSound(player.location, Sound.BLOCK_END_PORTAL_FRAME_FILL , 1.0f, 1.0f)
                }

                // Ability #4 : Poison (10%)

                val random6 = rand.nextInt(100)
                if (random6 < 10) {
                    player.addPotionEffect(PotionEffect(PotionEffectType.POISON, 10, 2, true, false))
                    player.sendMessage("§cThe §7Ender §dKing §chas poisoned you!")
                    player.sendTitle("§4§lEnder King", "§chas poisoned you!", 1, 5, 1)
                    player.location.world.playSound(player.location, Sound.ENTITY_WITCH_THROW, 1.0f, 1.0f)
                }

                // Ability #5: Paralyze (10%)

                val random7 = rand.nextInt(100)
                if (random7 < 10) {
                    player.addPotionEffect(PotionEffect(PotionEffectType.WEAKNESS, 10, 2, true, false))
                    player.addPotionEffect(PotionEffect(PotionEffectType.BLINDNESS, 10, 5, true, false))
                    player.sendMessage("§cThe §7Ender §dKing §chas paralyzed you!")
                    player.sendTitle("§4§lEnder King", "§chas paralyzed you!", 1, 5, 1)
                    player.location.world.playSound(player.location, Sound.ENTITY_ELDER_GUARDIAN_CURSE, 1.0f, 1.0f)
                }
            }
        }
    }
}
