package com.wayads.backend_api.presentation.controller

import com.wayads.backend_api.application.service.FileStorageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import jakarta.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/api/v1/files")
class FileUploadController(
    private val fileStorageService: FileStorageService
) {

    @PostMapping("/upload")
    fun uploadFile(
        @RequestParam("file") file: MultipartFile,
        @RequestParam("folder", defaultValue = "general") folder: String
    ): ResponseEntity<Map<String, String>> {
        val filePath = fileStorageService.saveFile(file, folder)
        val fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path(filePath)
            .toUriString()

        val response = mapOf(
            "filePath" to filePath,
            "fileDownloadUri" to fileDownloadUri
        )
        return ResponseEntity.ok(response)
    }
}