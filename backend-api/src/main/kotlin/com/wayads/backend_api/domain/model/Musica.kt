package com.wayads.backend_api.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Lob

@Entity
class Musica(
    id: Long = 0,
    title: String,
    description: String? = null,
    posterUrl: String? = null,

    @Column(name = "artist_name")
    var artistName: String? = null,

    @Column(name = "audio_url")
    var audioUrl: String? = null, // link para o mp3 armazenado (S3, pasta local ou outro storage)

) : Entretenimento(id = id, title = title, description = description, posterUrl = posterUrl)
