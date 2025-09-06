package com.wayads.backend_api.application.dto

import java.math.BigDecimal
import java.time.LocalTime

// DTO para receber dados na criação e atualização de um ponto turístico
data class TurismoRequestDTO(
    val nome: String,
    val descricao: String,
    val categoria: String,
    val urlFotoPrincipal: String,
    val urlVideo: String? = null,
    val cidade: String,
    val estado: String,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val horarioAbertura: LocalTime? = null,
    val horarioFechamento: LocalTime? = null,
    val precoEntrada: BigDecimal? = null,
    val gratuito: Boolean = false
)

// DTO para enviar dados como resposta da API
data class TurismoResponseDTO(
    val id: Long,
    val nome: String,
    val descricao: String,
    val categoria: String,
    val urlFotoPrincipal: String,
    val urlVideo: String?,
    val cidade: String,
    val estado: String,
    val latitude: Double?,
    val longitude: Double?,
    val horarioAbertura: LocalTime?,
    val horarioFechamento: LocalTime?,
    val precoEntrada: BigDecimal?,
    val gratuito: Boolean
)