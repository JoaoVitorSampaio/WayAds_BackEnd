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
    fun uploadFile(@RequestParam("file") file: MultipartFile): ResponseEntity<Map<String, String>> {
        val fileName = fileStorageService.store(file)
        val fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/uploads/")
            .path(fileName)
            .toUriString()

        val response = mapOf("fileName" to fileName, "fileDownloadUri" to fileDownloadUri)
        return ResponseEntity.ok(response)
    }
}
