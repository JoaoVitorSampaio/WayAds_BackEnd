package com.wayads.backend_api.application.service

import com.wayads.backend_api.application.dto.request.KidsRequest
import com.wayads.backend_api.application.dto.response.KidsResponse
import com.wayads.backend_api.domain.repository.KidsRepository
import com.wayads.backend_api.infrastructure.exception.KidsNaoEncontradoException
import com.wayads.backend_api.infrastructure.utils.mapper.KidsMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KidsService(
    private val repository: KidsRepository
) {

    // Listar todos os desenhos
    @Transactional(readOnly = true)
    fun listarTodos(): List<KidsResponse> =
        repository.findAll().map { KidsMapper.toResponse(it) }

    // Buscar um desenho pelo ID
    @Transactional(readOnly = true)
    fun buscarPorId(id: Long): KidsResponse =
        KidsMapper.toResponse(
            repository.findById(id)
                .orElseThrow { KidsNaoEncontradoException("Desenho não encontrado") }
        )

    // Criar um novo desenho
    @Transactional
    fun criar(request: KidsRequest): KidsResponse {
        val entity = KidsMapper.toEntity(request)
        return KidsMapper.toResponse(repository.save(entity))
    }

    @Transactional
    fun atualizar(id: Long, request: KidsRequest): KidsResponse {
        val existente = repository.findById(id)
            .orElseThrow { KidsNaoEncontradoException("Desenho não encontrado") }

        existente.nome = request.nome
        existente.descricao = request.descricao
        existente.urlVideo = request.videoUrl

        return KidsMapper.toResponse(repository.save(existente))
    }

    // Deletar um desenho
    @Transactional
    fun deletar(id: Long) {
        repository.deleteById(id)
    }

    // Buscar desenhos por nome (opcional)
    @Transactional(readOnly = true)
    fun listarPorNome(nome: String): List<KidsResponse> =
        repository.findByNome(nome).map { KidsMapper.toResponse(it) }

    @Transactional(readOnly = true)
    fun buscarPorNomeUnico(nome: String): KidsResponse {
        val entity = repository.findByNome(nome).firstOrNull()
            ?: throw KidsNaoEncontradoException("Desenho com nome '$nome' não encontrado")
        return KidsMapper.toResponse(entity)
    }
}