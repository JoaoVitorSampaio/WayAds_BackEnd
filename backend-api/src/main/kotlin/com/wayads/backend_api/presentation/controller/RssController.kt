package com.wayads.backend_api.presentation.controller

import com.wayads.backend_api.application.service.RssService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RssController(
    private val rssService: RssService
) {
    @GetMapping("/api/rss/importar")
    fun importarNoticias(): String {
        rssService.importarNoticias()
        return "Importação de notícias concluída!"
    }
}