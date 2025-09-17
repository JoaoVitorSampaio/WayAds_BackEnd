package com.wayads.backend_api.application.service


import com.wayads.backend_api.application.dto.request.GastronomiaRequest
import com.wayads.backend_api.application.dto.response.GastronomiaResponse
import com.wayads.backend_api.domain.repository.GastronomiaRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class GastronomiaService(
    private val gastronomiaRepository: GastronomiaRepository
) {


    @Transactional
    fun criar(request: GastronomiaRequest): GastronomiaResponse {
        val novaGastronomia = request.toEntity()
        val gastronomiaSalva = gastronomiaRepository.save(novaGastronomia)
        return GastronomiaResponse.fromEntity(gastronomiaSalva)
    }


    @Transactional(readOnly = true)
    fun listarTodos(): List<GastronomiaResponse> {
        return gastronomiaRepository.findAll().map { GastronomiaResponse.fromEntity(it) }
    }


    @Transactional(readOnly = true)
    fun buscarPorId(id: Long): GastronomiaResponse {
        val gastronomia = gastronomiaRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Ponto gastronômico com ID $id não encontrado.") }
        return GastronomiaResponse.fromEntity(gastronomia)
    }


    @Transactional
    fun atualizar(id: Long, request: GastronomiaRequest): GastronomiaResponse {
        val gastronomiaExistente = gastronomiaRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Ponto gastronômico com ID $id não encontrado para atualização.") }


        // Atualiza os campos da entidade existente
        gastronomiaExistente.apply {
            nome = request.nome
            descricao = request.descricao
            localizacao = request.localizacao
            imagemUrl = request.imagemUrl
            categoria = request.categoria
            fonte = request.fonte
        }


        val gastronomiaAtualizada = gastronomiaRepository.save(gastronomiaExistente)
        return GastronomiaResponse.fromEntity(gastronomiaAtualizada)
    }


    @Transactional
    fun remover(id: Long) {
        if (!gastronomiaRepository.existsById(id)) {
            throw EntityNotFoundException("Ponto gastronômico com ID $id não encontrado para remoção.")
        }
        gastronomiaRepository.deleteById(id)
    }
}