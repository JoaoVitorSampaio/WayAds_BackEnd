package com.wayads.backend_api.application.dto.request


import com.wayads.backend_api.domain.model.PontoGastronomico
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size


data class PontoGastronomicoRequest(
    @field:NotBlank(message = "O nome não pode ser vazio.")
    @field:Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    val nome: String,


    @field:NotBlank(message = "A descrição não pode ser vazia.")
    @field:Size(max = 1000, message = "A descrição deve ter no máximo 1000 caracteres.")
    val descricao: String,


    @field:NotBlank(message = "A localização não pode ser vazia.")
    val localizacao: String,


    @field:NotBlank(message = "A URL da imagem não pode ser vazia.")
    val imagemUrl: String,


    @field:NotBlank(message = "A categoria não pode ser vazia.")
    val categoria: String,


    val fonte: String?
) {
    fun toEntity(): PontoGastronomico {
        return PontoGastronomico(
            nome = this.nome,
            descricao = this.descricao,
            localizacao = this.localizacao,
            imagemUrl = this.imagemUrl,
            categoria = this.categoria,
            fonte = this.fonte
        )
    }
}
