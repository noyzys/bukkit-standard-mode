package io.github.noyzys.cpvp.standard.common.extension

import io.github.noyzys.cpvp.standard.common.extension.colored
import org.bukkit.entity.Player

/**
 * @author: noyzys on 20:14, 18.12.2020
 **/
fun Player.send(message: String) = sendMessage(message.colored())