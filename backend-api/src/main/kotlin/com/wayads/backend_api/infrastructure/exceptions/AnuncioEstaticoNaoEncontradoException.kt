
package com.wayads.backend_api.infrastructure.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class AnuncioEstaticoNaoEncontradoException(id: Long) : RuntimeException("Anúncio estático com ID $id não encontrado.")
