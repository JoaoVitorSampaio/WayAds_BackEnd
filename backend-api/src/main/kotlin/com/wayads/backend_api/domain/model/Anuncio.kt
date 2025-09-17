package com.wayads.backend_api.domain.model

import  jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

// Objeto de valor para agrupar dados de geolocalização
@Embeddable
data class Localizacao(
    var latitude: Double? = null,
    var longitude: Double? = null,
    var raioCobertura: Double? = null
)

@Entity
@Table(name = "anuncios")
data class Anuncio(
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
    var videoUrl: String? = null,

    @Column(nullable = false)
    var ativo: Boolean = true,

    // Agora é 'val' e não nulo, garantindo que a data de criação é imutável.
    @Column(nullable = false, updatable = false)
    val dataInicio: LocalDateTime = LocalDateTime.now(),

    var dataFim: LocalDateTime? = null,

    var prioridade: Int = 0,

    // Usando o objeto de valor @Embeddable
    @Embedded
    var localizacao: Localizacao? = null,

    // Métricas não devem ser nulas
    var visualizacoes: Long = 0,
    var cliques: Long = 0,
    var interacoes: Long = 0
) {

}