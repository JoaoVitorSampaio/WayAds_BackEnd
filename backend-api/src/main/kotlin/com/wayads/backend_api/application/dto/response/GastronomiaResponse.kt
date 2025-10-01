package com.wayads.backend_api.application.dto.response

import com.wayads.backend_api.domain.enums.CategoriaGastronomia
import java.time.LocalDateTime

data class GastronomiaResponse(
    val id: Long,
    val nome: String,
    val descricao: String,
    val localizacao: String?,
    val imagemUrl: String?,
    val categoria: CategoriaGastronomia,
    val fonte: String?,
    val criadoEm: LocalDateTime?,
    val atualizadoEm: LocalDateTime?
)
