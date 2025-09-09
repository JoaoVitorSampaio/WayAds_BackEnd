package com.wayads.backend_api.service

import com.wayads.backend_api.application.dto.request.TurismoRequestDTO
import com.wayads.backend_api.application.dto.response.TurismoResponseDTO
import com.wayads.backend_api.domain.model.LocalizacaoTurismo
import com.wayads.backend_api.domain.model.Turismo
import com.wayads.backend_api.domain.repository.TurismoRepository
import com.wayads.backend_api.infrastructure.exceptions.TurismoNaoEncontradoException
import com.wayads.backend_api.infrastructure.utils.mapper.TurismoMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TurismoService(
    private val turismoRepository: TurismoRepository
) {

    @Transactional(readOnly = true)
    fun listarTodos(): List<TurismoResponseDTO> =
        turismoRepository.findAll().map { TurismoMapper.toResponse(it) }

    @Transactional(readOnly = true)
    fun buscarPorId(id: Long): TurismoResponseDTO =
        TurismoMapper.toResponse(fetchTurismoById(id))

    @Transactional(readOnly = true)
    fun listarPorCidade(cidade: String): List<TurismoResponseDTO> =
        turismoRepository.findByLocalizacaoCidadeIgnoreCase(cidade)
            .map { TurismoMapper.toResponse(it) }

    @Transactional
    fun salvar(request: TurismoRequestDTO): TurismoResponseDTO {
        val novoTurismo = TurismoMapper.toEntity(request)
        val turismoSalvo = turismoRepository.save(novoTurismo)
        return TurismoMapper.toResponse(turismoSalvo)
    }

    @Transactional
    fun atualizar(id: Long, request: TurismoRequestDTO): TurismoResponseDTO {
        val turismoExistente = fetchTurismoById(id)

        turismoExistente.apply {
            nome = request.nome
            descricao = request.descricao
            categoria = request.categoria
            urlFotoPrincipal = request.urlFotoPrincipal
            urlVideo = request.urlVideo
            localizacao = LocalizacaoTurismo(
                cidade = request.cidade,
                estado = request.estado
            )
            latitude = request.latitude
            longitude = request.longitude
            horarioAbertura = request.horarioAbertura
            horarioFechamento = request.horarioFechamento
            gratuito = request.gratuito
        }

        val turismoAtualizado = turismoRepository.save(turismoExistente)
        return TurismoMapper.toResponse(turismoAtualizado)
    }

    @Transactional
    fun deletar(id: Long) {
        if (!turismoRepository.existsById(id)) {
            throw TurismoNaoEncontradoException(id)
        }
        turismoRepository.deleteById(id)
    }

    private fun fetchTurismoById(id: Long): Turismo =
        turismoRepository.findById(id)
            .orElseThrow { TurismoNaoEncontradoException(id) }
}
