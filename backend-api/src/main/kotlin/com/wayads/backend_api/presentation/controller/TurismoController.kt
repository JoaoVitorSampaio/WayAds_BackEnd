package com.wayads.backend_api.presentation.controller

import com.wayads.backend_api.application.dto.request.TurismoRequestDTO
import com.wayads.backend_api.application.dto.response.TurismoResponseDTO
import com.wayads.backend_api.domain.enums.CategoriaTurismo
import com.wayads.backend_api.service.TurismoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/turismo")
class TurismoController(
    private val turismoService: TurismoService
) {

    // GET /api/v1/turismo -> Listar todos os pontos turísticos
    @GetMapping
    fun listarTodos(): ResponseEntity<List<TurismoResponseDTO>> {
        val response = turismoService.listarTodos()
        return ResponseEntity.ok(response)
    }

    // GET /api/v1/turismo/{id} -> Buscar um ponto turístico por ID
    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<TurismoResponseDTO> {
        val response = turismoService.buscarPorId(id)
        return ResponseEntity.ok(response)
    }

    // GET /api/v1/turismo/cidade/{cidade} -> Listar pontos turísticos por cidade
    @GetMapping("/cidade/{cidade}")
    fun listarPorCidade(@PathVariable cidade: String): ResponseEntity<List<TurismoResponseDTO>> {
        val response = turismoService.listarPorCidade(cidade)
        return ResponseEntity.ok(response)
    }

    // GET /api/v1/turismo/categoria/{categoria} -> Listar pontos turísticos por categoria
    @GetMapping("/categoria/{categoria}")
    fun listarPorCategoria(@PathVariable categoria: CategoriaTurismo): ResponseEntity<List<TurismoResponseDTO>> {
        val response = turismoService.listarPorCategoria(categoria)
        return ResponseEntity.ok(response)
    }

    // POST /api/v1/turismo -> Criar um novo ponto turístico
    @PostMapping
    fun criar(@RequestBody request: TurismoRequestDTO): ResponseEntity<TurismoResponseDTO> {
        val response = turismoService.salvar(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    // PUT /api/v1/turismo/{id} -> Atualizar um ponto turístico existente
    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody request: TurismoRequestDTO): ResponseEntity<TurismoResponseDTO> {
        val response = turismoService.atualizar(id, request)
        return ResponseEntity.ok(response)
    }

    // DELETE /api/v1/turismo/{id} -> Remover um ponto turístico
    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long): ResponseEntity<Void> {
        turismoService.deletar(id)
        return ResponseEntity.noContent().build()
    }
}