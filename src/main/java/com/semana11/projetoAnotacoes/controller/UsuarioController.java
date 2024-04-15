package com.semana11.projetoAnotacoes.controller;

import com.semana11.projetoAnotacoes.datasource.entity.UsuarioEntity;
import com.semana11.projetoAnotacoes.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioEntity> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioEntity findById(@PathVariable Long id) {
        return usuarioService.findById(id).orElse(null);
    }

    @PostMapping
    public UsuarioEntity save(@RequestBody UsuarioEntity usuario) {
        return usuarioService.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }
}

