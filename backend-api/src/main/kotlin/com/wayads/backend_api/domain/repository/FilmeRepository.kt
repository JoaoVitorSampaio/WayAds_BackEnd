package com.wayads.backend_api.domain.repository

import com.wayads.backend_api.domain.model.Filme
import org.springframework.data.jpa.repository.JpaRepository

interface FilmeRepository : JpaRepository<Filme, Long>{
}