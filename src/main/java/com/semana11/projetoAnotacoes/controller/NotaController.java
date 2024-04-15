package com.semana11.projetoAnotacoes.controller;

import com.semana11.projetoAnotacoes.datasource.entity.NotaEntity;
import com.semana11.projetoAnotacoes.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @GetMapping
    public List<NotaEntity> findAll() {
        return notaService.findAll();
    }

    @GetMapping("/{id}")
    public NotaEntity findById(@PathVariable Long id) {
        return notaService.findById(id).orElse(null);
    }

    @PostMapping
    public NotaEntity save(@RequestBody NotaEntity nota) {
        return notaService.save(nota);
    }

    @PutMapping("/{id}")
    public NotaEntity update(@PathVariable Long id, @RequestBody NotaEntity nota) {
        return notaService.update(id, nota);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        notaService.deleteById(id);
    }
}

