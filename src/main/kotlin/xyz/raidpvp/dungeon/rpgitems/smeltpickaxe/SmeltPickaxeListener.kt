package xyz.raidpvp.dungeon.rpgitems.smeltpickaxe

import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import xyz.raidpvp.dungeon.rpgitems.SmeltPickaxe.*

class SmeltPickaxeListener : JavaPlugin(), Listener {
    override fun onEnable() {
        server.pluginManager.registerEvents(Coal(), this)
        server.pluginManager.registerEvents(Iron(), this)
        server.pluginManager.registerEvents(Gold(), this)
        server.pluginManager.registerEvents(Diamond(), this)
        server.pluginManager.registerEvents(Emerald(), this)
    }
}