package com.wayads.backend_api.service

import com.wayads.backend_api.application.dto.TurismoRequestDTO
import com.wayads.backend_api.application.dto.TurismoResponseDTO
import com.wayads.backend_api.domain.model.Turismo
import com.wayads.backend_api.domain.repository.TurismoRepository
import com.wayads.backend_api.infrastructure.exceptions.TurismoNaoEncontradoException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TurismoService(
    private val turismoRepository: TurismoRepository
) {

    @Transactional(readOnly = true)
    fun listarTodos(): List<TurismoResponseDTO> =
        turismoRepository.findAll().map { it.toResponseDTO() }

    @Transactional(readOnly = true)
    fun buscarPorId(id: Long): TurismoResponseDTO =
        fetchTurismoById(id).toResponseDTO()

    @Transactional
    fun salvar(request: TurismoRequestDTO): TurismoResponseDTO {
        val novoTurismo = request.toEntity()
        val turismoSalvo = turismoRepository.save(novoTurismo)
        return turismoSalvo.toResponseDTO()
    }

    @Transactional
    fun atualizar(id: Long, request: TurismoRequestDTO): TurismoResponseDTO {
        val turismoExistente = fetchTurismoById(id)

        // Atualiza o objeto existente com os novos dados
        turismoExistente.apply {
            nome = request.nome
            descricao = request.descricao
            categoria = request.categoria
            urlFotoPrincipal = request.urlFotoPrincipal
            urlVideo = request.urlVideo
            cidade = request.cidade
            estado = request.estado
            latitude = request.latitude
            longitude = request.longitude
            horarioAbertura = request.horarioAbertura
            horarioFechamento = request.horarioFechamento
            precoEntrada = request.precoEntrada
            gratuito = request.gratuito
        }

        val turismoAtualizado = turismoRepository.save(turismoExistente)
        return turismoAtualizado.toResponseDTO()
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

// Funções de Extensão para mapeamento limpo
private fun TurismoRequestDTO.toEntity(): Turismo = Turismo(
    nome = this.nome,
    descricao = this.descricao,
    categoria = this.categoria,
    urlFotoPrincipal = this.urlFotoPrincipal,
    urlVideo = this.urlVideo,
    cidade = this.cidade,
    estado = this.estado,
    latitude = this.latitude,
    longitude = this.longitude,
    horarioAbertura = this.horarioAbertura,
    horarioFechamento = this.horarioFechamento,
    precoEntrada = this.precoEntrada,
    gratuito = this.gratuito
)

private fun Turismo.toResponseDTO(): TurismoResponseDTO = TurismoResponseDTO(
    id = this.id!!,
    nome = this.nome,
    descricao = this.descricao,
    categoria = this.categoria,
    urlFotoPrincipal = this.urlFotoPrincipal,
    urlVideo = this.urlVideo,
    cidade = this.cidade,
    estado = this.estado,
    latitude = this.latitude,
    longitude = this.longitude,
    horarioAbertura = this.horarioAbertura,
    horarioFechamento = this.horarioFechamento,
    precoEntrada = this.precoEntrada,
    gratuito = this.gratuito
)