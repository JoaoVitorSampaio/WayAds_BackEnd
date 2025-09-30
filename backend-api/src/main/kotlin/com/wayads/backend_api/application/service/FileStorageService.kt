package com.wayads.backend_api.application.service

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.util.UUID

@Service
class FileStorageService {

    private val uploadDir = Paths.get("uploads")

    init {
        Files.createDirectories(uploadDir.resolve("posters"))
        Files.createDirectories(uploadDir.resolve("audios"))
    }

    fun saveFile(file: MultipartFile, folder: String): String {
        val targetDir = uploadDir.resolve(folder)
        val filename = "${UUID.randomUUID()}-${file.originalFilename}"
        val targetPath = targetDir.resolve(filename)
        Files.copy(file.inputStream, targetPath, StandardCopyOption.REPLACE_EXISTING)
        return "/files/$folder/$filename"
    }
}