package com.wayads.backend_api.domain.repository


import com.wayads.backend_api.domain.model.Gastronomia
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface GastronomiaRepository : JpaRepository<Gastronomia, Long> {
   fun findByCategoria(categoria: String): List<Gastronomia>
}
