package com.wayads.backend_api.presentation.controller

import com.wayads.backend_api.application.dto.request.KidsRequest
import com.wayads.backend_api.application.dto.response.KidsResponse
import com.wayads.backend_api.application.service.KidsService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/kids") // Prefixo para todos os endpoints da entidade Kids
class KidsController(
    private val service: KidsService
) {

    // Listar todos os desenhos
    @GetMapping
    fun listarTodos(): List<KidsResponse> = service.listarTodos()

    // Buscar por ID
    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): KidsResponse = service.buscarPorId(id)

    // Criar novo desenho
    @PostMapping
    fun criar(@RequestBody request: KidsRequest): KidsResponse = service.criar(request)

    // Atualizar desenho existente
    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody request: KidsRequest): KidsResponse =
        service.atualizar(id, request)

    // Deletar desenho
    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) = service.deletar(id)

    // Listar por nome (opcional)
    @GetMapping("/nome/{nome}")
    fun listarPorNome(@PathVariable nome: String): List<KidsResponse> =
        service.listarPorNome(nome)

    @GetMapping("/desenho/{nome}")
    fun buscarPorNomeUnico(@PathVariable nome: String): KidsResponse = 
        service.buscarPorNomeUnico(nome)
}