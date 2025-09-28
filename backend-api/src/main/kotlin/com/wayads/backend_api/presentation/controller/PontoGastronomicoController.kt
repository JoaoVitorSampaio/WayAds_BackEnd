package com.wayads.backend_api.presentation.controller


import com.wayads.backend_api.application.dto.request.PontoGastronomicoRequest
import com.wayads.backend_api.application.dto.response.PontoGastronomicoResponse
import com.wayads.backend_api.application.service.PontoGastronomicoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/v1/pontos-gastronomicos")
class PontoGastronomicoController(
   private val gastronomiaService: PontoGastronomicoService
) {


   // POST /api/gastronomia -> Cadastrar novo ponto gastronômico
   @PostMapping
   fun criar(@Valid @RequestBody requestDto: PontoGastronomicoRequest): ResponseEntity<PontoGastronomicoResponse> {
       val responseDto = gastronomiaService.criar(requestDto)
       return ResponseEntity.status(HttpStatus.CREATED).body(responseDto)
   }



   // GET /api/gastronomia -> Listar todos
   @GetMapping
   fun listarTodos(): ResponseEntity<List<PontoGastronomicoResponse>> {
       val response = gastronomiaService.listarTodos()
       return ResponseEntity.ok(response)
   }


   // GET /api/gastronomia/{id} -> Buscar por id
   @GetMapping("/{id}")
   fun buscarPorId(@PathVariable id: Long): ResponseEntity<PontoGastronomicoResponse> {
       val response = gastronomiaService.buscarPorId(id)
       return ResponseEntity.ok(response)
   }


   // PUT /api/gastronomia/{id} -> Atualizar
   @PutMapping("/{id}")
   fun atualizar(@PathVariable id: Long, @Valid @RequestBody request: PontoGastronomicoRequest): ResponseEntity<PontoGastronomicoResponse> {
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
