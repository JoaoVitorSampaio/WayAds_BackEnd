package com.wayads.backend_api.application.service

import com.wayads.backend_api.application.dto.response.TMDbNowPlayingResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.web.client.HttpClientErrorException
import org.slf4j.LoggerFactory

@Service
class TMDbService(
    private val restTemplate: RestTemplate
) {

    private val logger = LoggerFactory.getLogger(TMDbService::class.java)

    @Value("\${tmdb.api.key}")
    private lateinit var apiKey: String

    @Value("\${tmdb.api.bearer_token}")
    private lateinit var bearerToken: String

    private val baseUrl = "https://api.themoviedb.org/3"

    fun getNowPlayingMoviesV3(page: Int = 1): TMDbNowPlayingResponse? {
        val url = "$baseUrl/movie/now_playing?api_key=$apiKey&language=pt-BR&page=$page"
        return try {
            val response = restTemplate.getForObject(url, TMDbNowPlayingResponse::class.java)
            response?.results?.forEach { movie ->
                logger.info("Título: ${movie.title}, Data de Lançamento: ${movie.releaseDate}, Sinopse: ${movie.overview}")
            }
            response
        } catch (e: HttpClientErrorException) {
            logger.error("Erro ao buscar filmes em cartaz (v3): ${e.message}")
            null
        }
    }

    fun getNowPlayingMoviesV4(page: Int = 1): TMDbNowPlayingResponse? {
        val url = "$baseUrl/movie/now_playing?language=pt-BR&page=$page"
        val headers = HttpHeaders()
        headers.set("Authorization", "Bearer $bearerToken")
        val entity = HttpEntity<String>(headers)
        return try {
            val response = restTemplate.exchange(url, HttpMethod.GET, entity, TMDbNowPlayingResponse::class.java).body
            response?.results?.forEach { movie ->
                logger.info("Título: ${movie.title}, Data de Lançamento: ${movie.releaseDate}, Sinopse: ${movie.overview}")
            }
            response
        } catch (e: HttpClientErrorException) {
            logger.error("Erro ao buscar filmes em cartaz (v4): ${e.message}")
            null
        }
    }
}
