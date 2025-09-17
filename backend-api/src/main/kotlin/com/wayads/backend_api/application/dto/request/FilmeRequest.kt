package com.wayads.backend_api.application.dto.request

import jakarta.validation.constraints.NotBlank
import java.time.LocalDate

data class FilmeRequest(
    @field:NotBlank val title: String,
    val description: String?,
    val posterUrl: String?,
    val releaseDate: LocalDate?,
    val rating: Double?,
    val tmdbId: Long?
)
