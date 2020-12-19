package io.github.noyzys.cpvp.standard.structure.arena.repository

import io.github.noyzys.cpvp.standard.StandardPlugin
import io.github.noyzys.cpvp.standard.structure.arena.Arena
import io.vavr.collection.HashSet
import io.vavr.control.Option
import io.vavr.kotlin.option
import java.util.*
import kotlin.collections.HashMap

/**
 * @author: noyzys on 21:12, 18.12.2020
 **/
class ArenaRepository(private val standardPlugin: StandardPlugin) {

    private val standardArenas_ = HashMap<UUID, Arena>()
    val standardArenas get() = HashSet.ofAll(standardArenas_.values)

    fun addArena(arena: Arena) {
        standardArenas_[arena.arenaId] = arena
    }

    fun removeArena(uniqueId: UUID) = standardArenas_.remove(uniqueId)

    fun findArenaById(uniqueId: UUID): Option<Arena> =
        standardArenas_[uniqueId].option()
}
