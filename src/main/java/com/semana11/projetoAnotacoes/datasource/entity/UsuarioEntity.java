package com.semana11.projetoAnotacoes.datasource.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.Set;

@Entity
@Table(name = "usuario")
@Data
public class UsuarioEntity {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Getter
    @Column(unique = true)
    private String nomeUsuario;

    @Getter
    private String senha;

    @Getter
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_perfil",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )

    private Set<PerfilEntity> perfis;

}






