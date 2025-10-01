
package com.wayads.backend_api.domain.repository

import com.wayads.backend_api.domain.model.AnuncioEstatico
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnuncioEstaticoRepository : JpaRepository<AnuncioEstatico, Long> {

    fun findByAtivoTrue(): List<AnuncioEstatico>
}
