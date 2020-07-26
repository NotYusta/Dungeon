package xyz.raidpvp.dungeon.events

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.inventory.ItemStack
import java.util.*

class MobDrop : Listener {
    @EventHandler
    fun getCoin1(e: EntityDeathEvent) {
        val dead: Entity = e.entity
        if (dead.lastDamageCause is Player) {
            val p = dead.lastDamageCause as Player
            if (dead.type == EntityType.ZOMBIE) {
                val rnd = Random()
                val randomchance = rnd.nextInt(100)
                if (randomchance <= 0.5) {
                    giveCoins(3)
                    p.sendMessage(ChatColor.GREEN.toString() + "You are lucky and got" + ChatColor.RED + "a" + ChatColor.RED + "Raid" + ChatColor.YELLOW + "Coin")
                }
            }
        }
    }

    private fun giveCoins(i: Int) {
        val itemStack = ItemStack(Material.FIREBALL, i)
        val meta = itemStack.itemMeta
        meta.isUnbreakable = true
        meta.addEnchant(Enchantment.getByName("Enchantment.DAMAGE_ALL"), 1, true)
        meta.displayName = ChatColor.GOLD.toString() + "Raid" + ChatColor.BOLD + ChatColor.YELLOW + "Coin" + ChatColor.BOLD
        val lore: MutableList<String> = ArrayList()
        lore.add("")
        lore.add(ChatColor.GREEN.toString() + "UNCOMMON ITEM" + ChatColor.BOLD)
        lore.add(" ")
        lore.add(ChatColor.GRAY.toString() + "Can be used to crafting")
        lore.add(ChatColor.GRAY.toString() + "Obtained by slaying" + ChatColor.LIGHT_PURPLE + "Mobs")
    }
}