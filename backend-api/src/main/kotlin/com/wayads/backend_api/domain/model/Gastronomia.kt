package com.wayads.backend_api.domain.model


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
    var nome: String,


    @Column(nullable = false)
    var descricao: String,


    @Column(nullable = false)
    var localizacao: String,


    @Column
    var imagemUrl: String? = null,


    @Column(nullable = false)
    var categoria: String,


    @Column
    var fonte: String? = null,


    @CreatedDate
    @Column(name = "criado_em", updatable = false)
    val criadoEm: LocalDateTime? = null,


    @LastModifiedDate
    @Column(name = "atualizado_em")
    val atualizadoEm: LocalDateTime? = null
)
