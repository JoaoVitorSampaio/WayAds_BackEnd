package com.wayads.backend_api.infrastructure.utils.mapper

import com.wayads.backend_api.application.dto.request.FilmeRequest
import com.wayads.backend_api.application.dto.response.FilmeResponse
import com.wayads.backend_api.application.dto.response.TMDbMovieResponse
import com.wayads.backend_api.domain.model.Filme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object FilmeMapper {
    fun toEntity(req: FilmeRequest): Filme =
        Filme(
            title = req.title,
            description = req.description,
            posterUrl = req.posterUrl,
            releaseDate = req.releaseDate,
            rating = req.rating,
            tmdbId = req.tmdbId
        )

    fun toResponse(entity: Filme): FilmeResponse =
        FilmeResponse(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            posterUrl = entity.posterUrl,
            createdAt = entity.createdAt,
            releaseDate = entity.releaseDate,
            rating = entity.rating,
            tmdbId = entity.tmdbId
        )

    fun fromTMDb(tmdbMovie: TMDbMovieResponse): Filme {
        val posterBaseUrl = "https://image.tmdb.org/t/p/w500"
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val releaseDate = LocalDate.parse(tmdbMovie.releaseDate, formatter)
        return Filme(
            title = tmdbMovie.title,
            description = tmdbMovie.overview,
            posterUrl = posterBaseUrl + tmdbMovie.posterPath,
            releaseDate = releaseDate,
            rating = 0.0, // TMDb API does not provide rating in this endpoint
            tmdbId = tmdbMovie.id
        )
    }
}
