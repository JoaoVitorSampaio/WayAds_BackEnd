package com.wayads.backend_api.presentation.controller

import com.wayads.backend_api.application.dto.request.GastronomiaRequest
import com.wayads.backend_api.application.dto.response.GastronomiaResponse
import com.wayads.backend_api.application.service.GastronomiaService
import com.wayads.backend_api.domain.enums.CategoriaGastronomia
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/gastronomia")
class GastronomiaController(
   private val gastronomiaService: GastronomiaService
) {

   @PostMapping
   fun criar(@Valid @RequestBody requestDto: GastronomiaRequest): ResponseEntity<GastronomiaResponse> {
       val responseDto = gastronomiaService.criar(requestDto)
       return ResponseEntity.status(HttpStatus.CREATED).body(responseDto)
   }

   @GetMapping
   fun listarTodos(): ResponseEntity<List<GastronomiaResponse>> {
       val response = gastronomiaService.listarTodos()
       return ResponseEntity.ok(response)
   }

   @GetMapping("/{id}")
   fun buscarPorId(@PathVariable id: Long): ResponseEntity<GastronomiaResponse> {
       val response = gastronomiaService.buscarPorId(id)
       return ResponseEntity.ok(response)
   }

    @GetMapping("/categoria/{categoria}")
    fun listarPorCategoria(@PathVariable categoria: CategoriaGastronomia): ResponseEntity<List<GastronomiaResponse>> {
        val response = gastronomiaService.listarPorCategoria(categoria)
        return ResponseEntity.ok(response)
    }

   @PutMapping("/{id}")
   fun atualizar(@PathVariable id: Long, @Valid @RequestBody request: GastronomiaRequest): ResponseEntity<GastronomiaResponse> {
       val response = gastronomiaService.atualizar(id, request)
       return ResponseEntity.ok(response)
   }

   @DeleteMapping("/{id}")
   fun remover(@PathVariable id: Long): ResponseEntity<Void> {
       gastronomiaService.remover(id)
       return ResponseEntity.noContent().build()
   }
}
