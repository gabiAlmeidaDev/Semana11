package com.semana11.projetoAnotacoes.datasource.repository;

import com.semana11.projetoAnotacoes.datasource.entity.CadernoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadernoRepository extends JpaRepository<CadernoEntity, Long> {
}
