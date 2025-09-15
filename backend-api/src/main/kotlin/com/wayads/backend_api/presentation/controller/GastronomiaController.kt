package com.wayads.presentation.controller


import com.wayads.application.dto.GastronomiaRequest
import com.wayads.application.dto.GastronomiaResponse
import com.wayads.application.service.GastronomiaService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI


@RestController
@RequestMapping("api/v1/gastronomia")
class GastronomiaController(
   private val gastronomiaService: GastronomiaService
) {


   // POST /api/gastronomia -> Cadastrar novo ponto gastronômico
   @PostMapping
   fun criar(@Valid @RequestBody requestDto: GastronomiaRequest): ResponseEntity<GastronomiaResponse> {
       val responseDto = gastronomiaService.criar(requestDto)
       return ResponseEntity.status(HttpStatus.CREATED).body(responseDto)
   }



   // GET /api/gastronomia -> Listar todos
   @GetMapping
   fun listarTodos(): ResponseEntity<List<GastronomiaResponse>> {
       val response = gastronomiaService.listarTodos()
       return ResponseEntity.ok(response)
   }


   // GET /api/gastronomia/{id} -> Buscar por id
   @GetMapping("/{id}")
   fun buscarPorId(@PathVariable id: Long): ResponseEntity<GastronomiaResponse> {
       val response = gastronomiaService.buscarPorId(id)
       return ResponseEntity.ok(response)
   }


   // PUT /api/gastronomia/{id} -> Atualizar
   @PutMapping("/{id}")
   fun atualizar(@PathVariable id: Long, @Valid @RequestBody request: GastronomiaRequest): ResponseEntity<GastronomiaResponse> {
       val response = gastronomiaService.atualizar(id, request)
       return ResponseEntity.ok(response)
   }


   // DELETE /api/gastronomia/{id} -> Remover
   @DeleteMapping("/{id}")
   fun remover(@PathVariable id: Long): ResponseEntity<Void> {
       gastronomiaService.remover(id)
       return ResponseEntity.noContent().build()
   }
}
