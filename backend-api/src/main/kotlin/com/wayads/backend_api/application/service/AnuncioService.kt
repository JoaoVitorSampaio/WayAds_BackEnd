package com.wayads.backend_api.application.service

import com.wayads.backend_api.application.dto.AnuncioRequestDTO
import com.wayads.backend_api.application.dto.AnuncioResponseDTO
import com.wayads.backend_api.domain.model.Anuncio
import com.wayads.backend_api.domain.model.Localizacao
import com.wayads.backend_api.domain.repository.AnuncioRepository
import com.wayads.backend_api.infrastructure.exception.AnuncioNaoEncontradoException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AnuncioService(
    private val anuncioRepository: AnuncioRepository
) {

    // Adicionamos @Transactional para garantir consistência em operações de escrita
    @Transactional(readOnly = true)
    fun listarTodos(): List<AnuncioResponseDTO> =
        anuncioRepository.findAll().map { it.toResponseDTO() }

    @Transactional(readOnly = true)
    fun buscarPorId(id: Long): AnuncioResponseDTO =
        fetchAnuncioById(id).toResponseDTO()

    @Transactional
    fun salvar(request: AnuncioRequestDTO): AnuncioResponseDTO {
        val novoAnuncio = request.toEntity()
        val anuncioSalvo = anuncioRepository.save(novoAnuncio)
        return anuncioSalvo.toResponseDTO()
    }

    @Transactional
    fun atualizar(id: Long, request: AnuncioRequestDTO): AnuncioResponseDTO {
        val anuncioExistente = fetchAnuncioById(id)

        // Atualiza o objeto existente com os novos dados
        anuncioExistente.apply {
            titulo = request.titulo
            descricao = request.descricao
            imagemUrl = request.imagemUrl
            videoUrl = request.videoUrl
            ativo = request.ativo
            dataFim = request.dataFim
            prioridade = request.prioridade
            localizacao = Localizacao(
                latitude = request.latitude,
                longitude = request.longitude,
                raioCobertura = request.raioCobertura
            )
        }

        val anuncioAtualizado = anuncioRepository.save(anuncioExistente)
        return anuncioAtualizado.toResponseDTO()
    }

    @Transactional
    fun deletar(id: Long) {
        if (!anuncioRepository.existsById(id)) {
            throw AnuncioNaoEncontradoException(id)
        }
        anuncioRepository.deleteById(id)
    }

    // Método privado para evitar repetição de código
    private fun fetchAnuncioById(id: Long): Anuncio =
        anuncioRepository.findById(id)
            .orElseThrow { AnuncioNaoEncontradoException(id) }
}

// Extension Functions para mapeamento limpo entre DTOs e Entidades
private fun AnuncioRequestDTO.toEntity(): Anuncio = Anuncio(
    titulo = this.titulo,
    descricao = this.descricao,
    imagemUrl = this.imagemUrl,
    videoUrl = this.videoUrl,
    ativo = this.ativo,
    dataFim = this.dataFim,
    prioridade = this.prioridade,
    localizacao = Localizacao(
        latitude = this.latitude,
        longitude = this.longitude,
        raioCobertura = this.raioCobertura
    )
    // dataInicio é gerado automaticamente na entidade
)

private fun Anuncio.toResponseDTO(): AnuncioResponseDTO = AnuncioResponseDTO(
    id = this.id!!, // ID não será nulo para uma entidade que já existe
    titulo = this.titulo,
    descricao = this.descricao,
    imagemUrl = this.imagemUrl,
    videoUrl = this.videoUrl,
    ativo = this.ativo,
    dataInicio = this.dataInicio,
    dataFim = this.dataFim,
    prioridade = this.prioridade,
    latitude = this.localizacao?.latitude,
    longitude = this.localizacao?.longitude,
    visualizacoes = this.visualizacoes,
    cliques = this.cliques
)