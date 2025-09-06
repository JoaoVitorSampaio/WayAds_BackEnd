package com.wayads.backend_api.infrastructure.utils.mapper

import com.wayads.backend_api.application.dto.request.AtualidadeRequest
import com.wayads.backend_api.application.dto.response.AtualidadeResponse
import com.wayads.backend_api.domain.model.Atualidade

object AtualidadeMapper {
    fun toEntity(request: AtualidadeRequest): Atualidade =
        Atualidade(
            categoria = request.categoria,
            titulo = request.titulo,
            descricao = request.descricao,
            fotoUrl = request.fotoUrl,
            fonte = request.fonte,
            linkQr = request.linkQr
        )

    fun toResponse(entity: Atualidade): AtualidadeResponse =
        AtualidadeResponse(
            id = entity.id,
            categoria = entity.categoria,
            titulo = entity.titulo,
            descricao = entity.descricao,
            fotoUrl = entity.fotoUrl,
            fonte = entity.fonte,
            linkQr = entity.linkQr,
            criadoEm = entity.criadoEm
        )
}