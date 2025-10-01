package com.wayads.backend_api.presentation.controller

import com.wayads.backend_api.application.dto.request.ReceitaRequest
import com.wayads.backend_api.application.dto.response.ReceitaResponse
import com.wayads.backend_api.application.service.ReceitaService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/receitas")
class ReceitaController(
    private val receitaService: ReceitaService
) {

    @PostMapping
    fun criar(@Valid @RequestBody request: ReceitaRequest): ResponseEntity<ReceitaResponse> {
        val response = receitaService.criar(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @GetMapping
    fun listarTodas(): ResponseEntity<List<ReceitaResponse>> {
        val response = receitaService.listarTodas()
        return ResponseEntity.ok(response)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<ReceitaResponse> {
        val response = receitaService.buscarPorId(id)
        return ResponseEntity.ok(response)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @Valid @RequestBody request: ReceitaRequest): ResponseEntity<ReceitaResponse> {
        val response = receitaService.atualizar(id, request)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/{id}")
    fun remover(@PathVariable id: Long): ResponseEntity<Void> {
        receitaService.remover(id)
        return ResponseEntity.noContent().build()
    }
}
