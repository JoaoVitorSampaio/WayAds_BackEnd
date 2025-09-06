package com.wayads.backend_api.application.service

import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import com.wayads.backend_api.domain.enums.Categoria
import com.wayads.backend_api.domain.model.Atualidade
import com.wayads.backend_api.domain.repository.AtualidadeRepository
import org.springframework.stereotype.Service
import java.net.URL

@Service
class RssService(
    private val repository: AtualidadeRepository
) {
    private val feedsPorCategoria = mapOf(
        Categoria.POLITICA to "https://g1.globo.com/rss/g1/politica/",
        Categoria.ECONOMIA to "https://g1.globo.com/rss/g1/economia/",
        Categoria.MUNDO to "https://g1.globo.com/rss/g1/mundo/",
        Categoria.TECNOLOGIA to "https://g1.globo.com/rss/g1/tecnologia/"
    )
    private fun extrairImagem(html: String): String {
        val regex = Regex("src=\\\"(.*?)\\\"")
        return regex.find(html)?.groupValues?.get(1) ?: ""
    }

    private fun limparHtml(html: String): String {
        return html.replace(Regex("<.*?>"), "").trim()
    }

    fun importarNoticias() {
        feedsPorCategoria.forEach { (categoria, urlStr) ->
            val url = URL(urlStr)
            val feed = SyndFeedInput().build(XmlReader(url))

            feed.entries.forEach { entry ->
                val descricaoHtml = entry.description?.value ?: ""
                val fotoUrl = extrairImagem(descricaoHtml)

                val noticia = Atualidade(
                    categoria = categoria,
                    titulo = entry.title,
                    descricao = limparHtml(descricaoHtml).take(200),
                    fotoUrl = fotoUrl,
                    fonte = "G1",
                    linkQr = entry.link
                )
                repository.save(noticia)
            }
        }
    }
}
