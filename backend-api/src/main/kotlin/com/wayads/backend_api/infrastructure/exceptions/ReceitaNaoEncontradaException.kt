package com.wayads.backend_api.infrastructure.exceptions

import jakarta.persistence.EntityNotFoundException

class ReceitaNaoEncontradaException(id: Long) : EntityNotFoundException("Receita com ID $id não encontrada.")
