package com.wayads.backend_api.application.dto.request

import java.time.LocalDateTime

// DTO para receber dados na criação e atualização de um anúncio
data class AnuncioRequestDTO(
    val titulo: String,
    val descricao: String,
    val imagemUrl: String? = null,
    val videoUrl: String? = null,
    val ativo: Boolean = true,
    val dataInicio: LocalDateTime? = null, // Nulo para usar a data atual como padrão
    val dataFim: LocalDateTime? = null,
    val prioridade: Int = 0,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val raioCobertura: Double? = null
)

