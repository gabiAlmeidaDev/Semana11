package com.semana11.projetoAnotacoes.controller;

import com.semana11.projetoAnotacoes.datasource.entity.CadernoEntity;
import com.semana11.projetoAnotacoes.service.CadernoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cadernos")
public class CadernoController {

    @Autowired
    private CadernoService cadernoService;

    @GetMapping
    public List<CadernoEntity> findAll() {

        return cadernoService.findAll();
    }

    @GetMapping("/{id}")
    public CadernoEntity findById(@PathVariable Long id) {

        return cadernoService.findById(id).orElse(null);
    }

    @PostMapping
    public CadernoEntity save(@RequestBody CadernoEntity caderno) {

        return cadernoService.save(caderno);
    }

    @PutMapping("/{id}")
    public CadernoEntity update(@PathVariable Long id, @RequestBody CadernoEntity caderno) {
        return cadernoService.update(id, caderno);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {

        cadernoService.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<CadernoEntity>> getAllCadernosForCurrentUser() {
        List<CadernoEntity> cadernos = cadernoService.findAllCadernosForCurrentUser();
        return ResponseEntity.ok(cadernos);
    }
}
