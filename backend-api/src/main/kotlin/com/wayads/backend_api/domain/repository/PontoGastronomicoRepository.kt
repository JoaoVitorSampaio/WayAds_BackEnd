package com.wayads.backend_api.domain.repository


import com.wayads.backend_api.domain.model.PontoGastronomico
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PontoGastronomicoRepository : JpaRepository<PontoGastronomico, Long> {
   fun findByCategoria(categoria: String): List<PontoGastronomico>
}
