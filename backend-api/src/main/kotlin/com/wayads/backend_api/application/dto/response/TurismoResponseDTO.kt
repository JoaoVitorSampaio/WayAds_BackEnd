package com.wayads.backend_api.application.dto.response

import java.math.BigDecimal
import java.time.LocalTime

data class TurismoResponseDTO(
    val id: Long,
    var nome: String,
    var descricao: String,
    var categoria: String,
    var urlFotoPrincipal: String,
    var urlVideo: String?,
    var cidade: String,
    var estado: String,
    var latitude: Double?,
    var longitude: Double?,
    var horarioAbertura: LocalTime?,
    var horarioFechamento: LocalTime?,
    var precoEntrada: BigDecimal?,
    var gratuito: Boolean
)