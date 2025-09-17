package com.wayads.backend_api.domain.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Entretenimento(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    open val id: Long = 0,

    open var title: String,

    @Column(length = 2000)
    open var description: String? = null,

    open var posterUrl: String? = null,

    open var createdAt: LocalDateTime = LocalDateTime.now()
)