package com.wayads.backend_api.domain.model

import jakarta.persistence.*
import java.util.*

@Entity
data class  Kids(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var nome: String,

    @Lob
    @Column(columnDefinition = "TEXT")
    var descricao: String,

    @Lob
    @Column(columnDefinition = "TEXT")
    var urlVideo: String,

    var ativo: Boolean = true,

    val criadoEm: Date = Date()
)
