package com.wayads.backend_api.application.dto.request

import jakarta.validation.constraints.NotBlank

data class MusicaRequest(
    @field:NotBlank val title: String,
    val description: String?,
    val posterUrl: String?,   // capa do álbum
    val artistName: String?,
    val audioUrl: String?     // link do arquivo mp3
)