
package com.wayads.backend_api.presentation.controller

import com.wayads.backend_api.application.service.FileStorageService
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/videos")
class VideoController(private val fileStorageService: FileStorageService) {

    @GetMapping("/{folder}/{filename:.+}")
    fun streamVideo(@PathVariable folder: String, @PathVariable filename: String): ResponseEntity<Resource> {
        val resource = fileStorageService.loadFileAsResource(filename, folder)
        val contentType = fileStorageService.getVideoContentType(filename)

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_TYPE, contentType)
            .body(resource)
    }
}
