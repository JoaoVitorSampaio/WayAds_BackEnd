package com.wayads.backend_api.presentation.controller

import com.wayads.backend_api.application.dto.request.MusicaRequest
import com.wayads.backend_api.application.dto.response.MusicaResponse
import com.wayads.backend_api.application.service.FileStorageService
import com.wayads.backend_api.application.service.MusicaService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1/musicas")
class MusicaController(
    private val service: MusicaService,
    private val fileStorageService: FileStorageService
) {

    @GetMapping
    fun list(pageable: Pageable): Page<MusicaResponse> = service.findAll(pageable)

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    fun uploadMusica(
            @RequestParam("title") title: String,
            @RequestParam("artistName", required = false) artistName: String?,
            @RequestParam("description", required = false) description: String?,
            @RequestParam("poster") poster: MultipartFile,
            @RequestParam("audio") audio: MultipartFile
    ): MusicaResponse {
        val posterPath = fileStorageService.saveFile(poster, "posters")
        val audioPath = fileStorageService.saveFile(audio, "audios")

        val req = MusicaRequest(
            title = title,
            description = description,
            posterUrl = posterPath,
            artistName = artistName,
            audioUrl = audioPath
        )

        return service.create(req)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): MusicaResponse = service.findById(id)
}