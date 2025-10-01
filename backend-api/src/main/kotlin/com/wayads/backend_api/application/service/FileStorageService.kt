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
        Files.createDirectories(uploadDir.resolve("general"))
    }

    fun saveFile(file: MultipartFile, folder: String): String {
        val targetDir = uploadDir.resolve(folder)
        val filename = "${UUID.randomUUID()}-${file.originalFilename}"
        val targetPath = targetDir.resolve(filename)
        Files.copy(file.inputStream, targetPath, StandardCopyOption.REPLACE_EXISTING)

        // 🔑 Não retorna path do Windows, só relativo
        return "/api/v1/videos/$folder/$filename"
    }

    fun loadFileAsResource(filename: String, folder: String): org.springframework.core.io.Resource {
        val targetDir = uploadDir.resolve(folder)
        val filePath = targetDir.resolve(filename).normalize()
        val resource = org.springframework.core.io.UrlResource(filePath.toUri())

        if (resource.exists() && resource.isReadable) {
            return resource
        } else {
            throw RuntimeException("Could not read the file!")
        }
    }

    fun getVideoContentType(filename: String): String {
        return when (filename.substringAfterLast('.', "").lowercase()) {
            "mp4" -> "video/mp4"
            "webm" -> "video/webm"
            "ogg" -> "video/ogg"
            else -> "application/octet-stream"
        }
    }
}
