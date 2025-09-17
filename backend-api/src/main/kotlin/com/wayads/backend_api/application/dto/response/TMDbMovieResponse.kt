package com.wayads.backend_api.application.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class TMDbMovieResponse(
    val id: Long,
    val title: String,
    val overview: String,
    @JsonProperty("poster_path")
    val posterPath: String,
    @JsonProperty("release_date")
    val releaseDate: String
)
