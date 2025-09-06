package com.wayads.backend_api.presentation.controller


import com.wayads.backend_api.application.dto.request.AnuncioRequestDTO
import com.wayads.backend_api.application.dto.response.AnuncioResponseDTO
import com.wayads.backend_api.application.service.AnuncioService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/api/v1/anuncios")
class AnuncioController(
    private val anuncioService: AnuncioService
) {
    @GetMapping
    fun listarTodos(): ResponseEntity<List<AnuncioResponseDTO>> =
        ResponseEntity.ok(anuncioService.listarTodos())

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<AnuncioResponseDTO> =
        ResponseEntity.ok(anuncioService.buscarPorId(id))

    @PostMapping
    fun criar(@RequestBody requestDto: AnuncioRequestDTO): ResponseEntity<AnuncioResponseDTO> {
        val responseDto = anuncioService.salvar(requestDto)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(responseDto.id)
            .toUri()
        // Retorna 201 Created com a localização do novo recurso
        return ResponseEntity.created(uri).body(responseDto)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody requestDto: AnuncioRequestDTO): ResponseEntity<AnuncioResponseDTO> =
        ResponseEntity.ok(anuncioService.atualizar(id, requestDto))

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long): ResponseEntity<Void> {
        anuncioService.deletar(id)
        // Retorna 204 No Content para exclusão bem-sucedida
        return ResponseEntity.noContent().build()
    }
}