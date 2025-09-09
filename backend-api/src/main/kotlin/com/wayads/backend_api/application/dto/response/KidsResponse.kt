package com.wayads.backend_api.application.dto.response

import java.util.*

data class KidsResponse(
    val id: Long,
    val nome: String,
    val descricao: String,
    val videoUrl: String,
    val criadoEm: Date
)