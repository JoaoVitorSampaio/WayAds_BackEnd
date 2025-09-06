package com.wayads.backend_api.application.dto.response

import com.wayads.backend_api.domain.enums.Categoria
import java.util.*

data class AtualidadeResponse(
    val id: Long,
    val categoria: Categoria,
    val titulo: String,
    val descricao: String,
    val fotoUrl: String,
    val fonte: String,
    val linkQr: String,
    val criadoEm: Date
)