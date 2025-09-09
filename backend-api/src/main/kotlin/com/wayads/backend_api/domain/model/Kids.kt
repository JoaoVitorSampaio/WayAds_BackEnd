package com.wayads.backend_api.domain.model

import jakarta.persistence.*
import java.util.*

@Entity
data class Kids(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0, // ID autogerado pelo banco

    val nome: String, // Nome do desenho (ex: Galinha Pintadinha)

    @Lob
    @Column(columnDefinition = "TEXT")
    val urlVideo: String, // Link ou caminho do vídeo

    val ativo: Boolean = true, // Define se o desenho está disponível para exibição

    val criadoEm: Date = Date() // Data de criação do registro
)