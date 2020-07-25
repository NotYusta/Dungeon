package dungeon.boss.entity

import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

val name1 = "${ChatColor.DARK_PURPLE} ${ChatColor.BOLD} Ender King"
val type1 = EntityType.ENDERMAN

class EnderKing(name: String = name1, type: EntityType = type1, damage : Int = 5, ){

    fun spawn(location: Location){
        //Entity spawning logic
    }

}