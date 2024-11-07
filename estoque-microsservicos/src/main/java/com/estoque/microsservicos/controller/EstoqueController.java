package com.estoque.microsservicos.controller;

import com.estoque.microsservicos.entity.Estoque;
import com.estoque.microsservicos.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public List<Estoque> listarEstoque() {
        return estoqueService.listarEstoque();
    }

    @GetMapping("/{id}")
    public Optional<Estoque> buscarEstoquePorId(@PathVariable Long id) {
        return estoqueService.buscarEstoquePorId(id);
    }

    @PutMapping
    public Estoque atualizarEstoque(@RequestBody Estoque estoque) {
        return estoqueService.atualizarEstoque(estoque);
    }

    @DeleteMapping("/{id}")
    public void deletarEstoque(@PathVariable Long id) {
        estoqueService.deletarEstoque(id);
    }
}
