package com.wayads.backend_api.domain.model

import com.wayads.backend_api.domain.enums.CategoriaTurismo
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalTime

@Embeddable
data class LocalizacaoTurismo( //lembrar refatorar isso aqui
    val cidade: String,
    val estado: String
)

@Entity
data class Turismo(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var nome: String,
    var descricao: String,
    @Enumerated(EnumType.STRING)
    var categoria: CategoriaTurismo,
    var urlFotoPrincipal: String,
    var urlVideo: String?,
    @Embedded
    var localizacao: LocalizacaoTurismo,
    var latitude: Double?,
    var longitude: Double?,
    var horarioAbertura: LocalTime?,
    var horarioFechamento: LocalTime?,
    var precoEntrada: BigDecimal?,
    var gratuito: Boolean
)
