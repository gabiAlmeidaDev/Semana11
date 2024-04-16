package com.semana11.projetoAnotacoes.datasource.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "caderno")
@Data
public class CadernoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "usuario_id")
    private Long idUsuario;

}
