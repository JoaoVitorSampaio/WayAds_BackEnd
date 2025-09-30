package com.wayads.backend_api.application.dto.response

import java.time.LocalDateTime

data class MusicaResponse(
    override val id: Long,
    override val title: String,
    override val description: String?,
    override val posterUrl: String?,
    override val createdAt: LocalDateTime,
    val artistName: String?,
    val audioUrl: String?
) : EntretenimentoResponse(id, title, description, posterUrl, createdAt)