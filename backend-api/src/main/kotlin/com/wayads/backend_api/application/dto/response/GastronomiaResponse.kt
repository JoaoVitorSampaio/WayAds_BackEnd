package com.wayads.backend_api.application.dto.response


import com.wayads.backend_api.domain.model.Gastronomia
import java.time.LocalDateTime


data class GastronomiaResponse(
    val id: Long,
    val nome: String,
    val descricao: String,
    val localizacao: String,
    val imagemUrl: String?,
    val categoria: String,
    val fonte: String?,
    val criadoEm: LocalDateTime?,
    val atualizadoEm: LocalDateTime?
) {
    companion object {
        fun fromEntity(gastronomia: Gastronomia): GastronomiaResponse {
            return GastronomiaResponse(
                id = gastronomia.id!!,
                nome = gastronomia.nome,
                descricao = gastronomia.descricao,
                localizacao = gastronomia.localizacao,
                imagemUrl = gastronomia.imagemUrl,
                categoria = gastronomia.categoria,
                fonte = gastronomia.fonte,
                criadoEm = gastronomia.criadoEm,
                atualizadoEm = gastronomia.atualizadoEm
            )
        }
    }
}
