package xyz.raidpvp.dungeon

import org.bukkit.plugin.java.JavaPlugin
import xyz.raidpvp.dungeon.boss.EnderKing
import xyz.raidpvp.dungeon.rpgitems.*
import xyz.raidpvp.dungeon.rpgitems.SmeltPickaxe.*
import xyz.raidpvp.dungeon.boss.enderking.*

class Dungeon : JavaPlugin() {
    override fun onEnable() {
        // RPG Items
            // Harvester Tools
        server.pluginManager.registerEvents(HarvesterHoe(), this)
        server.pluginManager.registerEvents(HarvesterAxe(), this)
            // Smelt Pickaxe
        server.pluginManager.registerEvents(CoalSP(), this)
        server.pluginManager.registerEvents(DiamondSP(), this)
        server.pluginManager.registerEvents(EmeraldSP(), this)
        server.pluginManager.registerEvents(GoldSP(), this)
        server.pluginManager.registerEvents(IronSP(), this)
        server.pluginManager.registerEvents(RedstoneSP(), this)
        // Boss
        server.pluginManager.registerEvents(Ability(), this)
        server.pluginManager.registerEvents(Effect(), this)
        // Events
            // MobDrop

        logger.info("[RaidPvP] Dungeon has been enabled!")
        logger.info("""  ____       _     _ ____        ____  
 |  _ \ __ _(_) __| |  _ \__   _|  _ \ 
 | |_) / _` | |/ _` | |_) \ \ / / |_) |
 |  _ < (_| | | (_| |  __/ \ V /|  __/ 
 |_| \_\__,_|_|\__,_|_|     \_/ |_|   """)
    }

    override fun onDisable() {
        logger.info("[RaidPvP] Dungeon has been unloaded!")
    }

}