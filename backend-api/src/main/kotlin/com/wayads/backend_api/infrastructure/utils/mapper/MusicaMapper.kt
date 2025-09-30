package com.wayads.backend_api.infrastructure.utils.mapper

import com.wayads.backend_api.application.dto.request.MusicaRequest
import com.wayads.backend_api.application.dto.response.MusicaResponse
import com.wayads.backend_api.domain.model.Musica

object MusicaMapper {
    @JvmStatic
    fun toEntity(req: MusicaRequest): Musica =
        Musica(
            title = req.title,
            description = req.description,
            posterUrl = req.posterUrl,
            artistName = req.artistName,
            audioUrl = req.audioUrl
        )

    @JvmStatic
    fun toResponse(entity: Musica): MusicaResponse =
        MusicaResponse(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            posterUrl = entity.posterUrl,
            createdAt = entity.createdAt,
            artistName = entity.artistName,
            audioUrl = entity.audioUrl
        )
}
