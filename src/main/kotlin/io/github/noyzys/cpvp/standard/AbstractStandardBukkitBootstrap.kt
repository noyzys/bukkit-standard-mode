package io.github.noyzys.cpvp.standard

import org.bukkit.plugin.java.JavaPlugin

/**
 * @author: noyzys on 20:51, 18.12.2020
 **/
abstract class AbstractStandardBukkitBootstrap(
    standardPlugin: JavaPlugin
) : AbstractStandardMaster(standardPlugin.dataFolder) {
}