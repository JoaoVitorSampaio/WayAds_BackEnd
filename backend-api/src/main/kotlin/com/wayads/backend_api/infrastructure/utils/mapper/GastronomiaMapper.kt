package com.wayads.infrastructure.utils.mapper

import com.wayads.application.dto.GastronomiaRequest
import com.wayads.application.dto.GastronomiaResponse
import com.wayads.domain.model.Gastronomia

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