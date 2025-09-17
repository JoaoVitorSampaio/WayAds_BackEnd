package com.wayads.backend_api.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import java.time.LocalDate

@Entity
class Filme(
    id: Long = 0,
    title: String,
    description: String? = null,
    posterUrl: String? = null,

    @Column(name = "release_date")
    var releaseDate: LocalDate? = null,

    @Column(name = "rating")
    var rating: Double? = null,

    @Column(name = "tmdb_id")
    var tmdbId: Long? = null
) : Entretenimento(id = id, title = title, description = description, posterUrl = posterUrl)