package io.github.noyzys.cpvp.standard.structure.user.repository

import io.github.noyzys.cpvp.standard.StandardPlugin
import io.github.noyzys.cpvp.standard.structure.user.UserProfile
import io.vavr.collection.HashSet
import io.vavr.control.Option
import io.vavr.kotlin.option
import org.bukkit.entity.Player
import java.util.*
import kotlin.collections.HashMap

/**
 * @author: noyzys on 22:06, 18.12.2020
 **/
class UserRepository(private val standardPlugin: StandardPlugin) {

    private val users_ = HashMap<UUID, UserProfile>()
    val users get() = HashSet.ofAll(users_.values)

    fun addUserToArena(userProfile: UserProfile) {
        users_[userProfile.uniqueId] = userProfile
    }

    fun removeUserFromArena(uniqueId: UUID) = users_.remove(uniqueId)

    fun findUser(player: Player) : Option<UserProfile> =
        this.findUser(player.uniqueId)

    fun findUser(uniqueId: UUID) : Option<UserProfile> =
        users_[uniqueId].option()
}