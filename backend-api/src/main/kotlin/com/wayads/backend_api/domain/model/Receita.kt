package com.wayads.backend_api.domain.model

import com.wayads.backend_api.domain.enums.NivelDificuldade
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "receitas")
data class Receita(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var nome: String,

    @Column(nullable = false, length = 1000)
    var descricao: String,

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "receita_ingredientes", joinColumns = [JoinColumn(name = "receita_id")])
    @Column(name = "ingrediente")
    var ingredientes: List<String> = listOf(),

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "receita_modo_preparo", joinColumns = [JoinColumn(name = "receita_id")])
    @Column(name = "passo")
    var modoPreparo: List<String> = listOf(),

    @Column
    var imagemUrl: String? = null,

    @Column
    var tempoPreparo: String? = null,

    @Column
    var porcoes: String? = null,

    @Enumerated(EnumType.STRING)
    @Column
    var nivelDificuldade: NivelDificuldade? = null,

    @CreatedDate
    @Column(name = "criado_em", updatable = false)
    val criadoEm: LocalDateTime? = null,

    @LastModifiedDate
    @Column(name = "atualizado_em")
    val atualizadoEm: LocalDateTime? = null
)