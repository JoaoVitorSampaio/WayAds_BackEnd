package com.wayads.backend_api.domain.repository

import com.wayads.backend_api.domain.model.Musica
import org.springframework.data.jpa.repository.JpaRepository

interface MusicaRepository : JpaRepository<Musica, Long>
