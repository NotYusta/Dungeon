package xyz.raidpvp.dungeon.boss

import org.bukkit.Material
import org.bukkit.entity.Enderman
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.metadata.FixedMetadataValue
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import xyz.raidpvp.dungeon.Dungeon

class Part1(private val plugin: Dungeon) : Listener {
    @EventHandler
    fun onRightClick(event: PlayerInteractEvent) {
        val p = event.player
        if (p.player.inventory.itemInMainHand.itemMeta.lore.contains("§7Ender §dKing §c§nSummoner")) {
            p.inventory.itemInMainHand = ItemStack(Material.AIR)
            val enderman = p.player.world.spawnEntity(p.player.location.add(0.5, 0.0, 0.5), EntityType.ENDERMAN) as Enderman
            enderman.customName = "§7Ender §dKing"
            enderman.isCustomNameVisible = true
            enderman.addPotionEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Int.MAX_VALUE, 10, true, false))
            enderman.addPotionEffect(PotionEffect(PotionEffectType.INCREASE_DAMAGE, Int.MAX_VALUE, 5, true, false))
            enderman.setMetadata("Ender King", FixedMetadataValue(plugin, "enderking"))
        }
    }
}