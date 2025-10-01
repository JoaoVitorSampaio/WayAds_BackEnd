
package com.wayads.backend_api.presentation.controller

import com.wayads.backend_api.application.dto.request.AnuncioEstaticoRequestDTO
import com.wayads.backend_api.application.dto.response.AnuncioEstaticoResponseDTO
import com.wayads.backend_api.application.service.AnuncioEstaticoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/api/v1/anuncios-estaticos")
class AnuncioEstaticoController(
    private val anuncioEstaticoService: AnuncioEstaticoService
) {
    @GetMapping
    fun listarTodos(): ResponseEntity<List<AnuncioEstaticoResponseDTO>> =
        ResponseEntity.ok(anuncioEstaticoService.listarTodos())

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<AnuncioEstaticoResponseDTO> =
        ResponseEntity.ok(anuncioEstaticoService.buscarPorId(id))

    @PostMapping
    fun criar(@RequestBody requestDto: AnuncioEstaticoRequestDTO): ResponseEntity<AnuncioEstaticoResponseDTO> {
        val responseDto = anuncioEstaticoService.salvar(requestDto)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(responseDto.id)
            .toUri()
        return ResponseEntity.created(uri).body(responseDto)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody requestDto: AnuncioEstaticoRequestDTO): ResponseEntity<AnuncioEstaticoResponseDTO> =
        ResponseEntity.ok(anuncioEstaticoService.atualizar(id, requestDto))

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long): ResponseEntity<Void> {
        anuncioEstaticoService.deletar(id)
        return ResponseEntity.noContent().build()
    }
}
