package com.semana11.projetoAnotacoes.controller;

import ch.qos.logback.core.boolex.Matcher;
import com.semana11.projetoAnotacoes.datasource.entity.UsuarioEntity;
import com.semana11.projetoAnotacoes.datasource.repository.UsuarioRepository;
import com.semana11.projetoAnotacoes.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @SneakyThrows
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        UsuarioRepository usuarioRepository = null;
        UsuarioEntity usuario = usuarioRepository.findByNomeUsuario(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Matcher bCryptPasswordEncoder = null;
        if (!bCryptPasswordEncoder.matches(password)) {
            return ResponseEntity.badRequest().body("Senha incorreta");
        }
        return null;
    }
}

