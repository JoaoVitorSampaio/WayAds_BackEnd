package com.wayads.backend_api.domain.repository

import com.wayads.backend_api.domain.model.Anuncio
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnuncioRepository : JpaRepository<Anuncio, Long> {

    /**
     * Exemplo de como adicionar uma consulta customizada no futuro.
     * O Spring Data JPA cria a implementação automaticamente com base no nome do método.
     *
     * @return Uma lista de anúncios que estão marcados como ativos.
     */
    fun findByAtivoTrue(): List<Anuncio>
}