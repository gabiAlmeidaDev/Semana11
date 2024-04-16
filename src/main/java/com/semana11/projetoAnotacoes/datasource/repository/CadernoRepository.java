package com.semana11.projetoAnotacoes.datasource.repository;

import com.semana11.projetoAnotacoes.datasource.entity.CadernoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadernoRepository extends JpaRepository<CadernoEntity, Long> {
    List<CadernoEntity> findByUsuarioId(Long usuarioId);
}
