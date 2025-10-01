package com.wayads.backend_api.infrastructure.utils.mapper

import com.wayads.backend_api.application.dto.request.GastronomiaRequest
import com.wayads.backend_api.application.dto.response.GastronomiaResponse
import com.wayads.backend_api.domain.model.Gastronomia

object GastronomiaMapper {

    fun toEntity(request: GastronomiaRequest): Gastronomia {
        return Gastronomia(
            nome = request.nome,
            descricao = request.descricao,
            localizacao = request.localizacao,
            imagemUrl = request.imagemUrl,
            categoria = request.categoria,
            fonte = request.fonte
        )
    }

    fun toResponse(entity: Gastronomia): GastronomiaResponse {
        return GastronomiaResponse(
            id = entity.id!!,
            nome = entity.nome,
            descricao = entity.descricao,
            localizacao = entity.localizacao,
            imagemUrl = entity.imagemUrl,
            categoria = entity.categoria,
            fonte = entity.fonte,
            criadoEm = entity.criadoEm,
            atualizadoEm = entity.atualizadoEm
        )
    }
}

