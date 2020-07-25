package xyz.raidpvp.dungeon

import org.bukkit.plugin.java.JavaPlugin
import xyz.raidpvp.dungeon.boss.Part1
import xyz.raidpvp.dungeon.rpgitems.*
import xyz.raidpvp.dungeon.events.*

internal class Dungeon : JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(Part1(), this)
        server.pluginManager.registerEvents(MobDrop(), this)
        server.pluginManager.registerEvents(HarvesterHoe(), this)
        server.pluginManager.registerEvents(HarvesterAxe(), this)
        logger.info("[RaidPvP] Dungeon has been enabled!")
        logger.info("""  _____ ____        ____
 |  _ \ __ _(_) __| |  _ \__   |  _ \
 | |_) / _` | |/ _` | |_) \ \ / / |_) |
 |  _ < (_| | | (_| |  __/ \ V /|   __/
 |_| \_\__,_|_|\__,_|_|  \_/ |_|
                                       """)
    }

    override fun onDisable() {
        logger.info("[RaidPvP] Dungeon has been unloaded!")
    }

}