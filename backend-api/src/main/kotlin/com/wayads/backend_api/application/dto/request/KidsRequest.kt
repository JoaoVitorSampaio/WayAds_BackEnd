package com.wayads.backend_api.application.dto.request

data class KidsRequest(
    val nome: String,       // Ex: "Galinha Pintadinha"
    val descricao: String,  // Curta descrição do desenho
    val videoUrl: String    // URL do vídeo que será exibido
)