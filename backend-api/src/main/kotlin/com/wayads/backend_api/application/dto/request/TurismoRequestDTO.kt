package com.wayads.backend_api.application.dto.request

import com.wayads.backend_api.domain.enums.CategoriaTurismo
import java.math.BigDecimal
import java.time.LocalTime

data class TurismoRequestDTO(
    var nome: String,
    var descricao: String,
    var categoria: CategoriaTurismo,
    var urlFotoPrincipal: String,
    var urlVideo: String? = null,
    var cidade: String,
    var estado: String,
    var latitude: Double? = null,
    var longitude: Double? = null,
    var horarioAbertura: LocalTime? = null,
    var horarioFechamento: LocalTime? = null,
    var precoEntrada: BigDecimal? = null,
    var gratuito: Boolean = false
)