package com.wayads.backend_api.application.dto.request

import com.wayads.backend_api.domain.enums.Categoria

data class AtualidadeRequest(
    val categoria: Categoria,
    val titulo: String,
    val descricao: String,
    val fotoUrl: String,
    val fonte: String,
    val linkQr: String
)