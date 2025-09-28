package com.wayads.backend_api.application.service


import com.wayads.backend_api.application.dto.request.PontoGastronomicoRequest
import com.wayads.backend_api.application.dto.response.PontoGastronomicoResponse
import com.wayads.backend_api.domain.repository.PontoGastronomicoRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class PontoGastronomicoService(
    private val gastronomiaRepository: PontoGastronomicoRepository
) {


    @Transactional
    fun criar(request: PontoGastronomicoRequest): PontoGastronomicoResponse {
        val novaGastronomia = request.toEntity()
        val gastronomiaSalva = gastronomiaRepository.save(novaGastronomia)
        return PontoGastronomicoResponse.fromEntity(gastronomiaSalva)
    }


    @Transactional(readOnly = true)
    fun listarTodos(): List<PontoGastronomicoResponse> {
        return gastronomiaRepository.findAll().map { PontoGastronomicoResponse.fromEntity(it) }
    }


    @Transactional(readOnly = true)
    fun buscarPorId(id: Long): PontoGastronomicoResponse {
        val gastronomia = gastronomiaRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Ponto gastronômico com ID $id não encontrado.") }
        return PontoGastronomicoResponse.fromEntity(gastronomia)
    }


    @Transactional
    fun atualizar(id: Long, request: PontoGastronomicoRequest): PontoGastronomicoResponse {
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
        return PontoGastronomicoResponse.fromEntity(gastronomiaAtualizada)
    }


    @Transactional
    fun remover(id: Long) {
        if (!gastronomiaRepository.existsById(id)) {
            throw EntityNotFoundException("Ponto gastronômico com ID $id não encontrado para remoção.")
        }
        gastronomiaRepository.deleteById(id)
    }
}