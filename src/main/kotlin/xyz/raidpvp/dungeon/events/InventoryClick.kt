package xyz.raidpvp.dungeon.events

import com.sun.xml.internal.bind.v2.TODO
import xyz.raidpvp.dungeon.boss.entity.EnderKing
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

class InventoryClick : Listener{

    @EventHandler
    fun onClick(event: InventoryClickEvent){
        if(!event.inventory.title.equals("Ender King Summoner")){
            return
        }
        if(event.currentItem.itemMeta.hasDisplayName()){
            if(event.currentItem.itemMeta.displayName != ChatColor.DARK_PURPLE.toString() + "Summon Ender King" + ChatColor.BOLD
                    || event.currentItem.type != Material.DRAGON_EGG){
                return
            }
        }
        //Spawn click logic
        EnderKing().spawn(event.whoClicked.location)
        TODO("Implement spawning of the boss")

    }
}