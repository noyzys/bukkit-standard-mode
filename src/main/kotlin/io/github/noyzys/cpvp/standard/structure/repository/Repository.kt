package io.github.noyzys.cpvp.standard.structure.repository

/**
 * @author: noyzys on 21:13, 18.12.2020
 **/
interface Repository<out T> {

    fun collectRepository(): T
}