package com.wayads.backend_api.domain.repository

import com.wayads.backend_api.domain.model.Turismo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TurismoRepository : JpaRepository<Turismo, Long> {

    /**
     * Exemplo de consulta customizada para encontrar pontos turísticos gratuitos.
     * O Spring Data JPA cria a implementação automaticamente com base no nome do método.
     *
     * @return Uma lista de pontos turísticos que estão marcados como gratuitos.
     */
    fun findByGratuitoTrue(): List<Turismo>

    /**
     * Outro exemplo de consulta, buscando por cidade e ignorando maiúsculas/minúsculas.
     *
     * @param cidade A cidade a ser pesquisada.
     * @return Uma lista de pontos turísticos da cidade especificada.
     */
    fun findByLocalizacaoCidadeIgnoreCase(cidade: String): List<Turismo>
}