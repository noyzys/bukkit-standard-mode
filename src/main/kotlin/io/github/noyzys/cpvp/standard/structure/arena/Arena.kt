package io.github.noyzys.cpvp.standard.structure.arena

import io.github.noyzys.cpvp.standard.StandardPlugin
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.Player
import java.util.*

/**
 * @author: noyzys on 21:05, 18.12.2020
 **/
data class Arena(
    val standardPlugin: StandardPlugin,
    val players: ArrayList<UUID>,
    val location: ArenaLocation
) {

    val arenaId: UUID get() = UUID.randomUUID()
    val defaultArenaState: ArenaState get() = ArenaState.WAITING
    fun players() = players.mapNotNull { standardPlugin.server.getPlayer(it) }
}

data class ArenaLocation(
    private val world: String,
    private val x: Double,
    private val y: Double,
    private val z: Double,
    private val yaw: Float,
    private val pitch: Float,
) {

    constructor(location: Location) : this(location.world!!.name, location.x, location.y,
        location.z, location.yaw, location.pitch)

    fun toBukkitLocation() : Location =
        Location(Bukkit.getWorld(world)!!, x, y, z, yaw, pitch)
}
