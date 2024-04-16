package com.semana11.projetoAnotacoes.service;

import com.semana11.projetoAnotacoes.datasource.entity.NotaEntity;
import com.semana11.projetoAnotacoes.datasource.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public NotaEntity update(Long id, NotaEntity notaDetails) {
        NotaEntity nota = notaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota com id: " + id + " não encontrada!"));
        nota.setTitle(notaDetails.getTitle());
        nota.setContent(notaDetails.getContent());
        nota.setIdCaderno(notaDetails.getIdCaderno());
        nota.setIdUsuario(notaDetails.getIdUsuario());
        return notaRepository.save(nota);
    }

    public void deleteById(Long id) {

        notaRepository.deleteById(id);
    }
    public List<NotaEntity> findAllNotasForCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName(); // Assume o nome de usuário é único

        Long userId = Long.valueOf(findUserIdByUsername(currentUsername)); // Implementar este método
        return notaRepository.findByUsuarioId(userId);
    }

    private String findUserIdByUsername(String currentUsername) {
        return currentUsername;
    }
}


