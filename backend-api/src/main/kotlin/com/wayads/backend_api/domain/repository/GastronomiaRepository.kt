package com.wayads.domain.repository


import com.wayads.domain.model.Gastronomia
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface GastronomiaRepository : JpaRepository<Gastronomia, Long> {
   fun findByCategoria(categoria: String): List<Gastronomia>
}
