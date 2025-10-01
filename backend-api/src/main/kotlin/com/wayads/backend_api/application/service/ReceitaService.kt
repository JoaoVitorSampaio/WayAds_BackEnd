package com.wayads.backend_api.application.service

import com.wayads.backend_api.application.dto.request.ReceitaRequest
import com.wayads.backend_api.application.dto.response.ReceitaResponse
import com.wayads.backend_api.domain.repository.ReceitaRepository
import com.wayads.backend_api.infrastructure.exceptions.ReceitaNaoEncontradaException
import com.wayads.backend_api.infrastructure.utils.mapper.ReceitaMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReceitaService(
    private val receitaRepository: ReceitaRepository
) {

    @Transactional
    fun criar(request: ReceitaRequest): ReceitaResponse {
        val novaReceita = ReceitaMapper.toEntity(request)
        val receitaSalva = receitaRepository.save(novaReceita)
        return ReceitaMapper.toResponse(receitaSalva)
    }

    @Transactional(readOnly = true)
    fun listarTodas(): List<ReceitaResponse> {
        return receitaRepository.findAll().map { ReceitaMapper.toResponse(it) }
    }

    @Transactional(readOnly = true)
    fun buscarPorId(id: Long): ReceitaResponse {
        val receita = receitaRepository.findById(id)
            .orElseThrow { ReceitaNaoEncontradaException(id) }
        return ReceitaMapper.toResponse(receita)
    }

    @Transactional
    fun atualizar(id: Long, request: ReceitaRequest): ReceitaResponse {
        val receitaExistente = receitaRepository.findById(id)
            .orElseThrow { ReceitaNaoEncontradaException(id) }

        receitaExistente.apply {
            nome = request.nome
            descricao = request.descricao
            ingredientes = request.ingredientes
            modoPreparo = request.modoPreparo
            imagemUrl = request.imagemUrl
            tempoPreparo = request.tempoPreparo
            porcoes = request.porcoes
            nivelDificuldade = request.nivelDificuldade
        }

        val receitaAtualizada = receitaRepository.save(receitaExistente)
        return ReceitaMapper.toResponse(receitaAtualizada)
    }

    @Transactional
    fun remover(id: Long) {
        if (!receitaRepository.existsById(id)) {
            throw ReceitaNaoEncontradaException(id)
        }
        receitaRepository.deleteById(id)
    }
}
