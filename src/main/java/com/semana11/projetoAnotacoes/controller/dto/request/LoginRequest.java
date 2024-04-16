package com.semana11.projetoAnotacoes.controller.dto.request;

public record LoginRequest(
        String nomeUsuario,
        String senha
) {
}
