package com.wayads.backend_api.application.dto.response

import java.time.LocalDateTime

open class EntretenimentoResponse(
    open val id: Long,
    open val title: String,
    open val description: String?,
    open val posterUrl: String?,
    open val createdAt: LocalDateTime
)