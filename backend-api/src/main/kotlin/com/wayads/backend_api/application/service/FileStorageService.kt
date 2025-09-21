package com.wayads.backend_api.application.service

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Path
import java.nio.file.Paths
import java.util.UUID
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import java.nio.file.Files

@Service
class FileStorageService {

    private val uploadDir: Path = Paths.get("uploads")

    init {
        try {
            Files.createDirectories(uploadDir)
        } catch (e: Exception) {
            throw RuntimeException("Could not initialize storage!", e)
        }
    }

    fun store(file: MultipartFile): String {
        val uniqueFileName = UUID.randomUUID().toString() + "_" + file.originalFilename
        try {
            if (file.isEmpty) {
                throw RuntimeException("Failed to store empty file.")
            }
            val destinationFile = this.uploadDir.resolve(uniqueFileName).normalize().toAbsolutePath()
            if (!destinationFile.parent.equals(this.uploadDir.toAbsolutePath())) {
                throw RuntimeException("Cannot store file outside current directory.")
            }
            file.inputStream.use { inputStream ->
                Files.copy(inputStream, destinationFile)
            }
            return uniqueFileName
        } catch (e: Exception) {
            throw RuntimeException("Failed to store file.", e)
        }
    }

    fun loadFileAsResource(fileName: String): Resource {
        try {
            val filePath = this.uploadDir.resolve(fileName).normalize()
            val resource = UrlResource(filePath.toUri())
            if (resource.exists()) {
                return resource
            } else {
                throw RuntimeException("File not found $fileName")
            }
        } catch (e: Exception) {
            throw RuntimeException("File not found $fileName", e)
        }
    }
}
