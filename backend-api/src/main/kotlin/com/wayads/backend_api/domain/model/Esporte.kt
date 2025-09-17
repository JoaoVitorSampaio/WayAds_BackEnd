package com.wayads.backend_api.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "sport_event")
class Esporte(
    id: Long = 0,
    title: String,
    description: String? = null,
    posterUrl: String? = null,

    @Column(name = "start_time")
    var startTime: LocalDateTime? = null,

    @Column(name = "location")
    var location: String? = null
) : Entretenimento(id = id, title = title, description = description, posterUrl = posterUrl)