package io.github.noyzys.cpvp.standard

import io.github.noyzys.cpvp.standard.common.configuration.ConfigurationLoader
import java.io.File

/**
 * @author: noyzys on 20:49, 18.12.2020
 **/
abstract class AbstractStandardMaster(
    dataFolder: File
) {

    val configurationLoader = ConfigurationLoader(dataFolder)

    abstract fun onEnable()
}