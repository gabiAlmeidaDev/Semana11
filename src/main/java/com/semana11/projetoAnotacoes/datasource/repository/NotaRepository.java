package com.semana11.projetoAnotacoes.datasource.repository;

import com.semana11.projetoAnotacoes.datasource.entity.NotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<NotaEntity, Long> {
}