package com.wayads.backend_api.application.dto.response

import com.wayads.backend_api.domain.enums.NivelDificuldade
import java.time.LocalDateTime

data class ReceitaResponse(
    val id: Long,
    val nome: String,
    val descricao: String,
    val ingredientes: List<String>,
    val modoPreparo: List<String>,
    val imagemUrl: String?,
    val tempoPreparo: String?,
    val porcoes: String?,
    val nivelDificuldade: NivelDificuldade?,
    val criadoEm: LocalDateTime?,
    val atualizadoEm: LocalDateTime?
)
