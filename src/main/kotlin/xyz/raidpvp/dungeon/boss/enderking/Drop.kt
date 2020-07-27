package xyz.raidpvp.dungeon.boss.enderking

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Enderman
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.inventory.ItemStack
import java.util.*


class Drop : Listener {
    @EventHandler
    fun onDeath(e: EntityDeathEvent) {
        if (e.entity is Enderman) {
            e.drops.clear()
            if (e.entity.hasMetadata("Ender King")) {
                val ek = e.entity as Enderman
                val enderhead = ItemStack(Material.ENDER_CHEST)
                val ehmeta = enderhead.itemMeta
                enderhead.addEnchantment(Enchantment.DAMAGE_ALL, 1)
                ehmeta.displayName = "§dEnder Head"
                ehmeta.lore = listOf("Please put desc", "second line of lore", "more")
                val rand = Random()
                val random = rand.nextInt(100)
                if (random < 15)
                    ek.location.world.dropItem(ek.location, ItemStack(enderhead))
            }
        }
    }
    private operator fun String.invoke(s: String) {
    }
}
