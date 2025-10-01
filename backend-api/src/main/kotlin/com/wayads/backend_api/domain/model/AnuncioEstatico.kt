
package com.wayads.backend_api.domain.model

import  jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

@Entity
@Table(name = "anuncios_estaticos")
data class AnuncioEstatico(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank
    @Column(nullable = false, length = 100)
    var titulo: String,

    @field:NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    var descricao: String,

    var imagemUrl: String? = null,

    @Column(nullable = false)
    var ativo: Boolean = true,

    @Column(nullable = false, updatable = false)
    val dataInicio: LocalDateTime = LocalDateTime.now(),

    var dataFim: LocalDateTime? = null,

    var prioridade: Int = 0,

    @Embedded
    var localizacao: Localizacao? = null,

    var visualizacoes: Long = 0,
    var cliques: Long = 0,
    var interacoes: Long = 0
)
