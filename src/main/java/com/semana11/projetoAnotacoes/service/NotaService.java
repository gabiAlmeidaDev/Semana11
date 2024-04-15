package com.semana11.projetoAnotacoes.service;

import com.semana11.projetoAnotacoes.datasource.entity.NotaEntity;
import com.semana11.projetoAnotacoes.datasource.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public List<NotaEntity> findAll() {
        return notaRepository.findAll();
    }

    public Optional<NotaEntity> findById(Long id) {
        return notaRepository.findById(id);
    }

    public NotaEntity save(NotaEntity nota) {
        return notaRepository.save(nota);
    }

    public void deleteById(Long id) {
        notaRepository.deleteById(id);
    }
}

