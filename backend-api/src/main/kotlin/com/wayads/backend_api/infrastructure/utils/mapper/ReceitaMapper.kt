package com.wayads.backend_api.infrastructure.utils.mapper

import com.wayads.backend_api.application.dto.request.ReceitaRequest
import com.wayads.backend_api.application.dto.response.ReceitaResponse
import com.wayads.backend_api.domain.model.Receita

object ReceitaMapper {

    fun toEntity(request: ReceitaRequest): Receita {
        return Receita(
            nome = request.nome,
            descricao = request.descricao,
            ingredientes = request.ingredientes,
            modoPreparo = request.modoPreparo,
            imagemUrl = request.imagemUrl,
            tempoPreparo = request.tempoPreparo,
            porcoes = request.porcoes,
            nivelDificuldade = request.nivelDificuldade
        )
    }

    fun toResponse(entity: Receita): ReceitaResponse {
        return ReceitaResponse(
            id = entity.id!!,
            nome = entity.nome,
            descricao = entity.descricao,
            ingredientes = entity.ingredientes,
            modoPreparo = entity.modoPreparo,
            imagemUrl = entity.imagemUrl,
            tempoPreparo = entity.tempoPreparo,
            porcoes = entity.porcoes,
            nivelDificuldade = entity.nivelDificuldade,
            criadoEm = entity.criadoEm,
            atualizadoEm = entity.atualizadoEm
        )
    }
}
