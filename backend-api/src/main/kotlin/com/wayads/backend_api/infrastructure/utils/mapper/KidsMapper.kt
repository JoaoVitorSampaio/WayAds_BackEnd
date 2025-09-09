package com.wayads.backend_api.infrastructure.utils.mapper

import com.wayads.backend_api.application.dto.request.KidsRequest
import com.wayads.backend_api.application.dto.response.KidsResponse
import com.wayads.backend_api.domain.model.Kids
import java.util.*

object KidsMapper {
    fun toEntity(request: KidsRequest) = Kids(
        nome = request.nome,
        descricao = request.descricao,
        videoUrl = request.videoUrl
    )

    fun toResponse(entity: Kids) = KidsResponse(
        id = entity.id,
        nome = entity.nome,
        descricao = entity.descricao,
        videoUrl = entity.videoUrl,
        criadoEm = entity.criadoEm
    )
}