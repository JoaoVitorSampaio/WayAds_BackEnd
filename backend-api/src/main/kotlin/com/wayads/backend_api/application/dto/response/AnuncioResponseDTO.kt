package com.wayads.backend_api.application.dto.response

import java.time.LocalDateTime

data class AnuncioResponseDTO(
    val id: Long,
    val titulo: String,
    val descricao: String,
    val imagemUrl: String?,
    val videoUrl: String?,
    val ativo: Boolean,
    val dataInicio: LocalDateTime,
    val dataFim: LocalDateTime?,
    val prioridade: Int,
    val latitude: Double?,
    val longitude: Double?,
    val visualizacoes: Long,
    val cliques: Long
)