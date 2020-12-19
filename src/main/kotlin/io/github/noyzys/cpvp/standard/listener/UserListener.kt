package io.github.noyzys.cpvp.standard.listener

import io.github.noyzys.cpvp.standard.StandardPlugin
import io.github.noyzys.cpvp.standard.structure.arena.ArenaLocation
import io.github.noyzys.cpvp.standard.structure.user.UserProfile
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerPreLoginEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerKickEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.inventory.ItemStack

/**
 * @author: noyzys on 12:50, 19.12.2020
 **/
class UserListener(
    private val standardPlugin: StandardPlugin
) : Listener {

    private val diamondSwordItem get() =
        ItemStack(Material.DIAMOND_SWORD, 1).addEnchantment(Enchantment.ARROW_DAMAGE, 5)
    private val diamondHelmetItem get() =
        ItemStack(Material.DIAMOND_HELMET, 1).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
    private val diamondHotplateItem get() =
        ItemStack(Material.DIAMOND_CHESTPLATE, 1).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
    private val diamondLeggingsItem get() =
        ItemStack(Material.DIAMOND_LEGGINGS, 1).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
    private val diamondBootsItem get() =
        ItemStack(Material.DIAMOND_BOOTS, 1).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)

    @EventHandler
    fun onUserLogin(event: AsyncPlayerPreLoginEvent) {
        val id = event.uniqueId

        standardPlugin.userRepository.findUser(id)
            .peek {
                standardPlugin.userRepository.addUserToArena(it)
            }.onEmpty {
                val userProfile = UserProfile(id)
                standardPlugin.userRepository.addUserToArena(userProfile)
            }
    }

    @EventHandler
    fun onUserJoin(event: PlayerJoinEvent) {
        val player = event.player
        val inventory = player.inventory

        inventory.clear()
        player.gameMode = GameMode.ADVENTURE
        inventory.armorContents
        // spawn
    }

    @EventHandler
    fun onUserQuit(event: PlayerQuitEvent) {
        val player = event.player
        val uniqueId = player.uniqueId
        standardPlugin.userRepository.findUser(player)
            .peek { standardPlugin.userRepository.removeUserFromArena(uniqueId) }
    }

    @EventHandler
    fun onUserKick(event: PlayerKickEvent) {
        val player = event.player
        val uniqueId = player.uniqueId
        standardPlugin.userRepository.findUser(player)
            .peek { standardPlugin.userRepository.removeUserFromArena(uniqueId) }
    }
}