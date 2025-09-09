package com.wayads.backend_api.domain.repository

import com.wayads.backend_api.domain.model.Turismo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TurismoRepository : JpaRepository<Turismo, Long> {
    fun findByGratuitoTrue(): List<Turismo>
    fun findByLocalizacaoCidadeIgnoreCase(cidade: String): List<Turismo>
    fun findByLocalizacaoEstadoIgnoreCase(estado: String): List<Turismo>
}
