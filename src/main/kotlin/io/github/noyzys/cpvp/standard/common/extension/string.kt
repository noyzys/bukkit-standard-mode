package io.github.noyzys.cpvp.standard.common.extension

import org.bukkit.ChatColor
import java.util.*

/**
 * @author: noyzys on 20:12, 18.12.2020
 **/
fun String.colored(): String =
    ChatColor.translateAlternateColorCodes('&', this)
