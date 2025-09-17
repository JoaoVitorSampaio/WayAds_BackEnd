package com.wayads.backend_api.application.dto.request

import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

data class EsporteRequest(
    @field:NotBlank val title: String,
    val description: String?,
    val posterUrl: String?,
    val startTime: LocalDateTime?,
    val location: String?
)