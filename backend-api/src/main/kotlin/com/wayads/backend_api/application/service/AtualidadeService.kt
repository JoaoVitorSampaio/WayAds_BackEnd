package com.wayads.backend_api.application.service

import com.wayads.backend_api.application.dto.request.AtualidadeRequest
import com.wayads.backend_api.application.dto.response.AtualidadeResponse
import com.wayads.backend_api.domain.enums.Categoria
import com.wayads.backend_api.domain.repository.AtualidadeRepository
import com.wayads.backend_api.infrastructure.utils.mapper.AtualidadeMapper
import org.springframework.stereotype.Service

@Service
class AtualidadeService(
    private val repository: AtualidadeRepository
) {
    fun listarTodas(): List<AtualidadeResponse> =
        repository.findAll().map { AtualidadeMapper.toResponse(it) }

    fun buscarPorId(id: Long): AtualidadeResponse =
        AtualidadeMapper.toResponse(
            repository.findById(id).orElseThrow { RuntimeException("Notícia não encontrada") }
        )

    fun listarPorCategoria(categoria: Categoria): List<AtualidadeResponse> =
        repository.findByCategoria(categoria).map { AtualidadeMapper.toResponse(it) }

    fun criar(request: AtualidadeRequest): AtualidadeResponse {
        val entity = AtualidadeMapper.toEntity(request)
        return AtualidadeMapper.toResponse(repository.save(entity))
    }

    fun atualizar(id: Long, request: AtualidadeRequest): AtualidadeResponse {
        val existente = repository.findById(id).orElseThrow { RuntimeException("Notícia não encontrada") }
        val atualizado = existente.copy(
            categoria = request.categoria,
            titulo = request.titulo,
            descricao = request.descricao,
            fotoUrl = request.fotoUrl,
            fonte = request.fonte,
            linkQr = request.linkQr
        )
        return AtualidadeMapper.toResponse(repository.save(atualizado))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}