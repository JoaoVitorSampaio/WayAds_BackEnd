package com.wayads.backend_api.application.service

import com.wayads.backend_api.application.dto.request.KidsRequest
import com.wayads.backend_api.application.dto.response.KidsResponse
import com.wayads.backend_api.domain.repository.KidsRepository
import com.wayads.backend_api.infrastructure.utils.mapper.KidsMapper
import org.springframework.stereotype.Service

@Service
class KidsService(
    private val repository: KidsRepository
) {

    // Listar todos os desenhos
    fun listarTodos(): List<KidsResponse> =
        repository.findAll().map { KidsMapper.toResponse(it) }

    // Buscar um desenho pelo ID
    fun buscarPorId(id: Long): KidsResponse =
        KidsMapper.toResponse(
            repository.findById(id)
                .orElseThrow { RuntimeException("Desenho não encontrado") }
        )

    // Criar um novo desenho
    fun criar(request: KidsRequest): KidsResponse {
        val entity = KidsMapper.toEntity(request)
        return KidsMapper.toResponse(repository.save(entity))
    }

    // Atualizar um desenho existente
    fun atualizar(id: Long, request: KidsRequest): KidsResponse {
        val existente = repository.findById(id)
            .orElseThrow { RuntimeException("Desenho não encontrado") }

        val atualizado = existente.copy(
            nome = request.nome,
            descricao = request.descricao,
            videoUrl = request.videoUrl
        )
        return KidsMapper.toResponse(repository.save(atualizado))
    }

    // Deletar um desenho
    fun deletar(id: Long) {
        repository.deleteById(id)
    }

    // Buscar desenhos por nome (opcional)
    fun listarPorNome(nome: String): List<KidsResponse> =
        repository.findByNome(nome).map { KidsMapper.toResponse(it) }
}