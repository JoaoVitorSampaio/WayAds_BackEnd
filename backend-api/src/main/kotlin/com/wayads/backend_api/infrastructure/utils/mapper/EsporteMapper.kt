package com.wayads.backend_api.infrastructure.utils.mapper

import com.wayads.backend_api.application.dto.request.EsporteRequest
import com.wayads.backend_api.application.dto.response.EsporteResponse
import com.wayads.backend_api.domain.model.Esporte

object EsporteMapper {
    fun toEntity(req: EsporteRequest): Esporte =
        Esporte(
            title = req.title,
            description = req.description,
            posterUrl = req.posterUrl,
            startTime = req.startTime,
            location = req.location
        )

    fun toResponse(entity: Esporte): EsporteResponse =
        EsporteResponse(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            posterUrl = entity.posterUrl,
            createdAt = entity.createdAt,
            startTime = entity.startTime,
            location = entity.location
        )
}