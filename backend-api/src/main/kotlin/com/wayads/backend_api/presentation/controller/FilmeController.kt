package com.wayads.backend_api.presentation.controller

import com.wayads.backend_api.application.dto.request.FilmeRequest
import com.wayads.backend_api.application.dto.response.FilmeResponse
import com.wayads.backend_api.application.service.FilmeService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/filmes")
class FilmeController(private val service: FilmeService) {
    @GetMapping
    fun list(pageable: Pageable): Page<FilmeResponse> = service.findAll(pageable)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): FilmeResponse = service.findById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid req: FilmeRequest): FilmeResponse = service.create(req)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid req: FilmeRequest): FilmeResponse =
        service.update(id, req)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) = service.delete(id)

    @PostMapping("/import/v3")
    @ResponseStatus(HttpStatus.CREATED)
    fun importV3(@RequestParam(defaultValue = "1") page: Int): String {
        service.importNowPlayingMoviesV3(page)
        return "Movies imported successfully using v3 API"
    }

    @PostMapping("/import/v4")
    @ResponseStatus(HttpStatus.CREATED)
    fun importV4(@RequestParam(defaultValue = "1") page: Int): String {
        service.importNowPlayingMoviesV4(page)
        return "Movies imported successfully using v4 API"
    }
}