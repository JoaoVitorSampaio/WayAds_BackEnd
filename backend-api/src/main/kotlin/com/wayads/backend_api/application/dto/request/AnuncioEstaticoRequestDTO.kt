
package com.wayads.backend_api.application.dto.request

import java.time.LocalDateTime

data class AnuncioEstaticoRequestDTO(
    val titulo: String,
    val descricao: String,
    val imagemUrl: String? = null,
    val ativo: Boolean = true,
    val dataInicio: LocalDateTime? = null,
    val dataFim: LocalDateTime? = null,
    val prioridade: Int = 0,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val raioCobertura: Double? = null
)
