package io.github.noyzys.cpvp.standard.common.builder

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

/**
 * @author: noyzys on 13:29, 19.12.2020
 **/
class ItemStackBuilder(
    private val material: Material,
    private val amount: Int,
    private val data: Int
    ) {

    fun toBuild() : ItemMeta {
        val itemStack = ItemStack(material, amount, data.toShort())
        val itemMeta = itemStack.itemMeta

        itemStack.itemMeta = itemMeta
        return itemMeta
    }
}