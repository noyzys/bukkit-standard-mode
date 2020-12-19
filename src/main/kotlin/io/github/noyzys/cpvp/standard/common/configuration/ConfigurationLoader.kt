package io.github.noyzys.cpvp.standard.common.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.apache.commons.io.output.ByteArrayOutputStream
import java.io.File
import java.nio.file.Files
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

/**
 * @author: noyzys on 20:18, 18.12.2020
 **/
class ConfigurationLoader(private val dataFolder: File) {

    private val mapper = ObjectMapper()
        .registerKotlinModule()

    private fun saveConfiguration(fileName: File, any: Any) {
        val file = File(dataFolder, "$fileName.json")

        val output = ByteArrayOutputStream()
        this.mapper
            .writerWithDefaultPrettyPrinter()
            .writeValue(output, any)

        Files.write(file.toPath(), output.toByteArray())
    }

    fun <T : Any> loadConfiguration(fileName: String, type: KClass<T>): T {
        val file = File(dataFolder, "$fileName.json")

        if (!file.exists()) {
            saveConfiguration(file, type.createInstance())
        }

        val encodeString = file.readText(Charsets.UTF_8)
        return this.mapper.readValue(encodeString, type.java)
    }
}
