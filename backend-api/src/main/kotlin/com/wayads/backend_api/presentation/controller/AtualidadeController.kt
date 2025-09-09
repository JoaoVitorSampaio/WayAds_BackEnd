package com.wayads.backend_api.presentation.controller

import com.wayads.backend_api.application.dto.request.AtualidadeRequest
import com.wayads.backend_api.application.dto.response.AtualidadeResponse
import com.wayads.backend_api.application.service.AtualidadeService
import com.wayads.backend_api.domain.enums.Categoria
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/atualidades")
class AtualidadeController(
    private val service: AtualidadeService
) {
    @GetMapping
    fun listarTodas(): List<AtualidadeResponse> = service.listarTodas()

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): AtualidadeResponse = service.buscarPorId(id)

    @GetMapping("/categoria/{categoria}")
    fun listarPorCategoria(@PathVariable categoria: Categoria): List<AtualidadeResponse> =
        service.listarPorCategoria(categoria)

    @PostMapping
    fun criar(@RequestBody request: AtualidadeRequest): AtualidadeResponse = service.criar(request)

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody request: AtualidadeRequest): AtualidadeResponse =
        service.atualizar(id, request)

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) = service.deletar(id)
}