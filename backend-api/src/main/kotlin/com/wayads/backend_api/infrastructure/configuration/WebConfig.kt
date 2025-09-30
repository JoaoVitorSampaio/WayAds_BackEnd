package com.wayads.backend_api.infrastructure.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig(
    @Value("\${file.upload-dir}") private val uploadDir: String
) : WebMvcConfigurer {

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        // mantém mapeamento antigo
        registry.addResourceHandler("/uploads/**")
            .addResourceLocations("file:uploads/")

        val pathNormalized = uploadDir.replace("\\", "/").trimEnd('/')
        registry.addResourceHandler("/files/**")
            .addResourceLocations("file:$pathNormalized/")
    }
}