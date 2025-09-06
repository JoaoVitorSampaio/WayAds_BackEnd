package com.wayads.backend_api.domain.model

import com.wayads.backend_api.domain.enums.Categoria
import jakarta.persistence.*
import java.util.*

@Entity
data class Atualidade(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Enumerated(EnumType.STRING)
    val categoria: Categoria,

    val titulo: String,

    @Lob
    @Column(columnDefinition = "TEXT")
    val descricao: String,

    @Lob
    @Column(columnDefinition = "TEXT")
    val fotoUrl: String,

    val fonte: String,

    @Lob
    @Column(columnDefinition = "TEXT")
    val linkQr: String,

    val criadoEm: Date = Date()
)