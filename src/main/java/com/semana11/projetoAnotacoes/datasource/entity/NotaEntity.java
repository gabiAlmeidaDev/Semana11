package com.semana11.projetoAnotacoes.datasource.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "nota")
@Data
public class NotaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @Column(name = "caderno_id")
    private Long idCaderno;

    @Column(name = "usuario_id")
    private Long usuarioId;


    public Long getIdUsuario() {
        return usuarioId;
    }
    public void setIdUsuario(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
