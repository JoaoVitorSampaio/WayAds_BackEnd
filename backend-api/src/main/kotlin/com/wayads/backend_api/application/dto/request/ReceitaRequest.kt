package com.wayads.backend_api.application.dto.request

import com.wayads.backend_api.domain.enums.NivelDificuldade
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class ReceitaRequest(
    @field:NotBlank(message = "O nome da receita não pode ser vazio.")
    @field:Size(max = 100)
    val nome: String,

    @field:NotBlank(message = "A descrição da receita não pode ser vazia.")
    @field:Size(max = 1000)
    val descricao: String,

    val ingredientes: List<String> = listOf(),

    val modoPreparo: List<String> = listOf(),

    val imagemUrl: String? = null,

    val tempoPreparo: String? = null,

    val porcoes: String? = null,

    val nivelDificuldade: NivelDificuldade? = null
)
