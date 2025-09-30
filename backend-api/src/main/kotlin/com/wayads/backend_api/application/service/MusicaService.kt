package com.wayads.backend_api.application.service

import com.wayads.backend_api.application.dto.request.MusicaRequest
import com.wayads.backend_api.application.dto.response.MusicaResponse
import com.wayads.backend_api.domain.repository.MusicaRepository
import com.wayads.backend_api.infrastructure.exceptions.ResourceNotFoundException
import com.wayads.backend_api.infrastructure.utils.mapper.MusicaMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MusicaService(
    private val repo: MusicaRepository
) {
    fun findAll(pageable: Pageable): Page<MusicaResponse> =
        repo.findAll(pageable).map(MusicaMapper::toResponse)

    fun findById(id: Long): MusicaResponse =
        repo.findById(id).map { MusicaMapper.toResponse(it) }
            .orElseThrow { ResourceNotFoundException("Musica", id) }

    fun create(req: MusicaRequest): MusicaResponse {
        val entity = MusicaMapper.toEntity(req)
        val saved = repo.save(entity)
        return MusicaMapper.toResponse(saved)
    }

    fun update(id: Long, req: MusicaRequest): MusicaResponse {
        val entity = repo.findById(id).orElseThrow { ResourceNotFoundException("Musica", id) }
        entity.title = req.title
        entity.description = req.description
        entity.posterUrl = req.posterUrl
        entity.artistName = req.artistName
        entity.audioUrl = req.audioUrl
        return MusicaMapper.toResponse(repo.save(entity))
    }

    fun delete(id: Long) {
        if (!repo.existsById(id)) throw ResourceNotFoundException("Musica", id)
        repo.deleteById(id)
    }
}