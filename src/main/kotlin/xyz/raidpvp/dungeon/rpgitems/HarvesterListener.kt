package xyz.raidpvp.dungeon.rpgitems

import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class HarvesterListener : JavaPlugin(), Listener {
    override fun onEnable() {
        server.pluginManager.registerEvents(HarvesterAxe(), this)
        server.pluginManager.registerEvents(HarvesterHoe(), this)
    }
}