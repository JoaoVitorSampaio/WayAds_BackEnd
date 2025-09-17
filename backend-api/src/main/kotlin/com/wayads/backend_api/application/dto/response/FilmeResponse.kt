package com.wayads.backend_api.application.dto.response

import java.time.LocalDate
import java.time.LocalDateTime

data class FilmeResponse(
    override val id: Long,
    override val title: String,
    override val description: String?,
    override val posterUrl: String?,
    override val createdAt: LocalDateTime,
    val releaseDate: LocalDate?,
    val rating: Double?,
    val tmdbId: Long?
) : EntretenimentoResponse(id, title, description, posterUrl, createdAt)