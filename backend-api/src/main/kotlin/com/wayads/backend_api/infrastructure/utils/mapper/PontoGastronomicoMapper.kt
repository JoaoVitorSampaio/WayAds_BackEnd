package com.wayads.backend_api.infrastructure.utils.mapper


import com.wayads.backend_api.application.dto.request.PontoGastronomicoRequest
import com.wayads.backend_api.application.dto.response.PontoGastronomicoResponse
import com.wayads.backend_api.domain.model.PontoGastronomico


object PontoGastronomicoMapper {
   fun toEntity(request: PontoGastronomicoRequest): PontoGastronomico {
       return PontoGastronomico(
           nome = request.nome,
           descricao = request.descricao,
           localizacao = request.localizacao,
           imagemUrl = request.imagemUrl,
           categoria = request.categoria,
           fonte = request.fonte
       )
   }


   fun toResponse(entity: PontoGastronomico): PontoGastronomicoResponse {
       return PontoGastronomicoResponse(
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

