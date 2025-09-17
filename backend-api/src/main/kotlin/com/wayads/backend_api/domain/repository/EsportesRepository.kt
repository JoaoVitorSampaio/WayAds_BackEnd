package com.wayads.backend_api.domain.repository

import com.wayads.backend_api.domain.model.Esporte
import org.springframework.data.jpa.repository.JpaRepository

interface EsportesRepository : JpaRepository<Esporte, Long> {
}