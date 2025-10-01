
package com.wayads.backend_api.application.service

import com.wayads.backend_api.application.dto.request.AnuncioEstaticoRequestDTO
import com.wayads.backend_api.application.dto.response.AnuncioEstaticoResponseDTO
import com.wayads.backend_api.domain.model.AnuncioEstatico
import com.wayads.backend_api.domain.model.Localizacao
import com.wayads.backend_api.domain.repository.AnuncioEstaticoRepository
import com.wayads.backend_api.infrastructure.exceptions.AnuncioEstaticoNaoEncontradoException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AnuncioEstaticoService(
    private val anuncioEstaticoRepository: AnuncioEstaticoRepository
) {

    @Transactional(readOnly = true)
    fun listarTodos(): List<AnuncioEstaticoResponseDTO> =
        anuncioEstaticoRepository.findAll().map { it.toResponseDTO() }

    @Transactional(readOnly = true)
    fun buscarPorId(id: Long): AnuncioEstaticoResponseDTO =
        fetchAnuncioEstaticoById(id).toResponseDTO()

    @Transactional
    fun salvar(request: AnuncioEstaticoRequestDTO): AnuncioEstaticoResponseDTO {
        val novoAnuncio = request.toEntity()
        val anuncioSalvo = anuncioEstaticoRepository.save(novoAnuncio)
        return anuncioSalvo.toResponseDTO()
    }

    @Transactional
    fun atualizar(id: Long, request: AnuncioEstaticoRequestDTO): AnuncioEstaticoResponseDTO {
        val anuncioExistente = fetchAnuncioEstaticoById(id)

        anuncioExistente.apply {
            titulo = request.titulo
            descricao = request.descricao
            imagemUrl = request.imagemUrl
            ativo = request.ativo
            dataFim = request.dataFim
            prioridade = request.prioridade
            localizacao = Localizacao(
                latitude = request.latitude,
                longitude = request.longitude,
                raioCobertura = request.raioCobertura
            )
        }

        val anuncioAtualizado = anuncioEstaticoRepository.save(anuncioExistente)
        return anuncioAtualizado.toResponseDTO()
    }

    @Transactional
    fun deletar(id: Long) {
        if (!anuncioEstaticoRepository.existsById(id)) {
            throw AnuncioEstaticoNaoEncontradoException(id)
        }
        anuncioEstaticoRepository.deleteById(id)
    }

    private fun fetchAnuncioEstaticoById(id: Long): AnuncioEstatico =
        anuncioEstaticoRepository.findById(id)
            .orElseThrow { AnuncioEstaticoNaoEncontradoException(id) }
}

private fun AnuncioEstaticoRequestDTO.toEntity(): AnuncioEstatico = AnuncioEstatico(
    titulo = this.titulo,
    descricao = this.descricao,
    imagemUrl = this.imagemUrl,
    ativo = this.ativo,
    dataFim = this.dataFim,
    prioridade = this.prioridade,
    localizacao = Localizacao(
        latitude = this.latitude,
        longitude = this.longitude,
        raioCobertura = this.raioCobertura
    )
)

private fun AnuncioEstatico.toResponseDTO(): AnuncioEstaticoResponseDTO = AnuncioEstaticoResponseDTO(
    id = this.id!!,
    titulo = this.titulo,
    descricao = this.descricao,
    imagemUrl = this.imagemUrl,
    ativo = this.ativo,
    dataInicio = this.dataInicio,
    dataFim = this.dataFim,
    prioridade = this.prioridade,
    latitude = this.localizacao?.latitude,
    longitude = this.localizacao?.longitude,
    visualizacoes = this.visualizacoes,
    cliques = this.cliques
)
