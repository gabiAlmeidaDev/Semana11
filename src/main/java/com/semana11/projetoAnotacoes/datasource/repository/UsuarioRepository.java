package com.semana11.projetoAnotacoes.datasource.repository;

import com.semana11.projetoAnotacoes.datasource.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}

