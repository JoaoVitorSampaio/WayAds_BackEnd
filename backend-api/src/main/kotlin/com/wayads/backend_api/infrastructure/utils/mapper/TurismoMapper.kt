package com.wayads.backend_api.infrastructure.utils.mapper

import com.wayads.backend_api.application.dto.request.TurismoRequestDTO
import com.wayads.backend_api.application.dto.response.TurismoResponseDTO
import com.wayads.backend_api.domain.model.LocalizacaoTurismo
import com.wayads.backend_api.domain.model.Turismo

object TurismoMapper {

    fun toEntity(dto: TurismoRequestDTO): Turismo = Turismo(
        nome = dto.nome,
        descricao = dto.descricao,
        categoria = dto.categoria,
        urlFotoPrincipal = dto.urlFotoPrincipal,
        urlVideo = dto.urlVideo,
        localizacao = LocalizacaoTurismo(
            cidade = dto.cidade,
            estado = dto.estado
        ),
        latitude = dto.latitude,
        longitude = dto.longitude,
        horarioAbertura = dto.horarioAbertura,
        horarioFechamento = dto.horarioFechamento,
        precoEntrada = dto.precoEntrada,
        gratuito = dto.gratuito
    )

    fun toResponse(entity: Turismo): TurismoResponseDTO = TurismoResponseDTO(
        id = entity.id!!,
        nome = entity.nome,
        descricao = entity.descricao,
        categoria = entity.categoria,
        urlFotoPrincipal = entity.urlFotoPrincipal,
        urlVideo = entity.urlVideo,
        cidade = entity.localizacao.cidade,
        estado = entity.localizacao.estado,
        latitude = entity.latitude,
        longitude = entity.longitude,
        horarioAbertura = entity.horarioAbertura,
        horarioFechamento = entity.horarioFechamento,
        precoEntrada = entity.precoEntrada,
        gratuito = entity.gratuito
    )
}
