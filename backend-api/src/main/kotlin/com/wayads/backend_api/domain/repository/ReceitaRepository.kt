package com.wayads.backend_api.domain.repository

import com.wayads.backend_api.domain.model.Receita
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReceitaRepository : JpaRepository<Receita, Long> {
}
