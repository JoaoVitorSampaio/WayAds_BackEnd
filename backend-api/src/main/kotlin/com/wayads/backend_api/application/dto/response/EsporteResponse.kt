package com.wayads.backend_api.application.dto.response

import java.time.LocalDateTime

data class EsporteResponse(
    override val id: Long,
    override val title: String,
    override val description: String?,
    override val posterUrl: String?,
    override val createdAt: LocalDateTime,
    val startTime: LocalDateTime?,
    val location: String?
) : EntretenimentoResponse(id, title, description, posterUrl, createdAt)