package com.semana11.projetoAnotacoes.service;

import com.semana11.projetoAnotacoes.datasource.entity.CadernoEntity;
import com.semana11.projetoAnotacoes.datasource.repository.CadernoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadernoService {

    @Autowired
    private CadernoRepository cadernoRepository;

    public List<CadernoEntity> findAll() {
        return cadernoRepository.findAll();
    }

    public Optional<CadernoEntity> findById(Long id) {
        return cadernoRepository.findById(id);
    }

    public CadernoEntity save(CadernoEntity caderno) {
        return cadernoRepository.save(caderno);
    }

    public CadernoEntity update(Long id, CadernoEntity cadernoDetails) {
        CadernoEntity caderno = cadernoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Caderno não encontrado com id: " + id));
        caderno.setNome(cadernoDetails.getNome());
        caderno.setIdUsuario(cadernoDetails.getIdUsuario());
        return cadernoRepository.save(caderno);
    }

    public void deleteById(Long id) {
        cadernoRepository.deleteById(id);
    }
}


