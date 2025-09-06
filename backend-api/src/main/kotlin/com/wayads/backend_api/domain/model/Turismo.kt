package com.wayads.backend_api.domain.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import java.math.BigDecimal
import java.time.LocalTime

@Entity
@Table(name = "turismo")
data class Turismo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank
    @Column(nullable = false, length = 150)
    var nome: String,

    @field:NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    var descricao: String,

    @Column(nullable = false, length = 50)
    var categoria: String,

    @Column(nullable = false)
    var urlFotoPrincipal: String,

    var urlVideo: String? = null,

    @Column(nullable = false, length = 100)
    var cidade: String,

    @Column(nullable = false, length = 2)
    var estado: String,

    var latitude: Double?,
    var longitude: Double?,

    var horarioAbertura: LocalTime? = null,
    var horarioFechamento: LocalTime? = null,

    @Column(precision = 10, scale = 2)
    var precoEntrada: BigDecimal? = null,

    @Column(nullable = false)
    var gratuito: Boolean = false
)