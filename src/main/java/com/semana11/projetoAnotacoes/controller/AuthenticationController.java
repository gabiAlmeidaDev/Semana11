package com.semana11.projetoAnotacoes.controller;

import com.semana11.projetoAnotacoes.datasource.entity.PerfilEntity;
import com.semana11.projetoAnotacoes.datasource.entity.UsuarioEntity;
import com.semana11.projetoAnotacoes.datasource.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private final JwtEncoder jwtEncoder;
    @Autowired
    private final UsuarioRepository usuarioRepository;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final long EXPIRATION_TIME = 72000L;

    public AuthenticationController(JwtEncoder jwtEncoder, UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtEncoder = jwtEncoder;
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        UsuarioEntity usuario = usuarioRepository.findByNomeUsuario(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!bCryptPasswordEncoder.matches(password, usuario.getSenha())) {
            return ResponseEntity.badRequest().body("Senha incorreta");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Instant now = Instant.now();
        String authorities = usuario.getPerfis()
                .stream()
                .map(PerfilEntity::getNome)
                .collect(Collectors.joining(" "));

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("YourApp")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(EXPIRATION_TIME))
                .subject(usuario.getId().toString())
                .claim("authorities", authorities)
                .build();

        String token = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(token);
    }
}

