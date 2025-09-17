package com.wayads.backend_api.application.service

import com.wayads.backend_api.application.dto.request.FilmeRequest
import com.wayads.backend_api.application.dto.response.FilmeResponse
import com.wayads.backend_api.domain.repository.FilmeRepository
import com.wayads.backend_api.infrastructure.exceptions.ResourceNotFoundException
import com.wayads.backend_api.infrastructure.utils.mapper.FilmeMapper
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
@Transactional
class FilmeService(
    private val repo: FilmeRepository,
    private val tmdbService: TMDbService
) {

    fun findAll(pageable: Pageable): Page<FilmeResponse> =
        repo.findAll(pageable).map(FilmeMapper::toResponse)


    fun findById(id: Long): FilmeResponse =
        repo.findById(id).map { FilmeMapper.toResponse(it) }
            .orElseThrow { ResourceNotFoundException("Movie", id) }

    fun create(req: FilmeRequest): FilmeResponse {
        val entity = FilmeMapper.toEntity(req)
        val saved = repo.save(entity)
        return FilmeMapper.toResponse(saved)
    }

    fun update(id: Long, req: FilmeRequest): FilmeResponse {
        val entity = repo.findById(id).orElseThrow { ResourceNotFoundException("Filme", id) }
        entity.title = req.title
        entity.description = req.description
        entity.posterUrl = req.posterUrl
        entity.releaseDate = req.releaseDate
        entity.rating = req.rating
        entity.tmdbId = req.tmdbId
        return FilmeMapper.toResponse(repo.save(entity))
    }

    fun delete(id: Long) {
        if (!repo.existsById(id)) throw ResourceNotFoundException("Filme", id)
        repo.deleteById(id)
    }

    fun importNowPlayingMoviesV3(page: Int = 1) {
        val nowPlayingMovies = tmdbService.getNowPlayingMoviesV3(page)
        nowPlayingMovies?.results?.forEach { tmdbMovie ->
            val filme = FilmeMapper.fromTMDb(tmdbMovie)
            repo.save(filme)
        }
    }

    fun importNowPlayingMoviesV4(page: Int = 1) {
        val nowPlayingMovies = tmdbService.getNowPlayingMoviesV4(page)
        nowPlayingMovies?.results?.forEach { tmdbMovie ->
            val filme = FilmeMapper.fromTMDb(tmdbMovie)
            repo.save(filme)
        }
    }
}