package io.github.noyzys.cpvp.standard.structure.arena.structure

import io.github.noyzys.cpvp.standard.structure.arena.Arena
import java.util.*

/**
 * @author: noyzys on 21:09, 18.12.2020
 **/
interface ArenaIncubator<in T> {

    fun addArena(arena: T)
    fun removeArena(arena: T)
    fun findArenaById(uniqueId: UUID)
}