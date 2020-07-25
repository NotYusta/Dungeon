package xyz.raidpvp.dungeon.boss

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import java.util.*

class Part1 : Listener {

    @EventHandler
    fun summonListener(e: PlayerInteractEvent): Boolean {
        val p = e.player
        val item = e.item
        val item2 = item.itemMeta
        if (e.action == Action.RIGHT_CLICK_AIR) {
            if (p.hasPermission("summon.mid")) {
                if (item != ItemStack(Material.SKULL)) if (item2.displayName == ChatColor.DARK_BLUE.toString() + "Ender King Summoner") {
                    p.openInventory(bossInventory())
                }
            }
        }
        return false
    }

    private fun bossInventory(): Inventory{
        //boss inventory logic
        val inv = Bukkit.createInventory(null, 9, "Ender King Summoner")
        val gpane1 = ItemStack(Material.STAINED_GLASS_PANE, 1, 10.toShort())
        val meta = gpane1.itemMeta
        meta.displayName = " "
        gpane1.itemMeta = meta
        val summon = ItemStack(Material.DRAGON_EGG)
        val metasummon = summon.itemMeta
        metasummon.displayName = ChatColor.DARK_PURPLE.toString() + "Summon Ender King" + ChatColor.BOLD
        val lore = ArrayList<String>()
        lore.add("Click to summon the almighty Ender King" + ChatColor.ITALIC)
        lore.add("Prepare. . ." + ChatColor.ITALIC)
        metasummon.lore = lore
        summon.itemMeta = metasummon
        val summonSlot = 25
        for(i in 0..inv.size){
            if(i == summonSlot){
                inv.setItem(i, summon)
                continue
            }
            inv.setItem(i, gpane1)
        }
        return inv
    }
}