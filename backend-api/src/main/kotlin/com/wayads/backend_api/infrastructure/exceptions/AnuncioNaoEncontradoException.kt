package com.wayads.backend_api.infrastructure.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

// Anotação para que o Spring retorne 404 Not Found por padrão
@ResponseStatus(HttpStatus.NOT_FOUND)
class AnuncioNaoEncontradoException(id: Long) : RuntimeException("Anúncio com ID $id não encontrado.")