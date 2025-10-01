package com.wayads.backend_api.application.dto.request

import com.wayads.backend_api.domain.enums.CategoriaGastronomia
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class GastronomiaRequest(
    @field:NotBlank(message = "O nome não pode ser vazio.")
    @field:Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    val nome: String,

    @field:NotBlank(message = "A descrição não pode ser vazia.")
    @field:Size(max = 1000, message = "A descrição deve ter no máximo 1000 caracteres.")
    val descricao: String,

    val localizacao: String?,

    val imagemUrl: String?,

    val categoria: CategoriaGastronomia,

    val fonte: String?
)
