package io.github.noyzys.cpvp.standard

import io.github.noyzys.cpvp.standard.structure.user.repository.UserRepository
import org.bukkit.Server
import org.bukkit.plugin.java.JavaPlugin

/**
 * @author: noyzys on 20:16, 18.12.2020
 **/
class StandardPlugin(
    private val standardPlugin: JavaPlugin
) : AbstractStandardBukkitBootstrap(standardPlugin) {

    val server: Server get() = standardPlugin.server
    lateinit var userRepository: UserRepository

    override fun onEnable() {
        userRepository = UserRepository(this)
    }
}