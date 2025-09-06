package com.wayads.backend_api.infrastructure.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class TurismoNaoEncontradoException(id: Long) : RuntimeException("Ponto turístico com ID $id não encontrado.")