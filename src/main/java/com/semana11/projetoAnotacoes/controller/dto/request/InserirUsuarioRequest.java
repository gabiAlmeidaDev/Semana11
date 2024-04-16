package com.semana11.projetoAnotacoes.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InserirUsuarioRequest {

    @JsonProperty("nomeUsuario")
    private String nomeUsuario;

    @JsonProperty("senha")
    private String senha;


    public InserirUsuarioRequest() {}


    public InserirUsuarioRequest(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}



