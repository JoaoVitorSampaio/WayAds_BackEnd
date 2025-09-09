package com.wayads.backend_api.infrastructure.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND) // Retorna 404 ao front-end
class KidsNaoEncontradoException(mensagem: String) : RuntimeException(mensagem)