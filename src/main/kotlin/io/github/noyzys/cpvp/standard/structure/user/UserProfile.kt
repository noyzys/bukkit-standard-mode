package io.github.noyzys.cpvp.standard.structure.user

import java.util.*
import kotlin.collections.HashSet

/**
 * @author: noyzys on 22:02, 18.12.2020
 **/
data class UserProfile(
    val uniqueId: UUID
) {

    val invites get() = HashSet<UUID>()
    val userState get() = UserState.WAIT
}
