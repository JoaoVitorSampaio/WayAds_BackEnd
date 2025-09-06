package com.wayads.backend_api.domain.repository

import com.wayads.backend_api.domain.enums.Categoria
import com.wayads.backend_api.domain.model.Atualidade
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AtualidadeRepository : JpaRepository<Atualidade, Long> {
    fun findByCategoria(categoria: Categoria): List<Atualidade>
}