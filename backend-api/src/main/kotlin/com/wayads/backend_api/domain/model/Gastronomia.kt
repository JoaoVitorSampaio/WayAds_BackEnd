package com.wayads.domain.model

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "gastronomia")
data class Gastronomia(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val nome: String,

    @Column(nullable = false)
    val descricao: String,

    @Column(nullable = false)
    val localizacao: String,

    @Column
    val imagemUrl: String? = null,

    @Column(nullable = false)
    val categoria: String,

    @Column
    val fonte: String? = null,

    @CreatedDate
    @Column(name = "criado_em", updatable = false)
    val criadoEm: LocalDateTime? = null,

    @LastModifiedDate
    @Column(name = "atualizado_em")
    val atualizadoEm: LocalDateTime? = null
)