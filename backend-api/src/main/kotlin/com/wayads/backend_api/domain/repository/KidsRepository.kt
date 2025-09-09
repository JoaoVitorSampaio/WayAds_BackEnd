package com.wayads.backend_api.domain.repository

import com.wayads.backend_api.domain.model.Kids
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface KidsRepository : JpaRepository<Kids, Long> {
    // Método opcional para buscar por nome do desenho
    fun findByNome(nome: String): List<Kids>
}