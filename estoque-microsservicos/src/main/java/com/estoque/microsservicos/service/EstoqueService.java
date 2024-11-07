package com.estoque.microsservicos.service;

import com.estoque.microsservicos.entity.Estoque;
import com.estoque.microsservicos.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public List<Estoque> listarEstoque() {
        return estoqueRepository.findAll();
    }

    public Optional<Estoque> buscarEstoquePorId(Long id) {
        return estoqueRepository.findById(id);
    }

    public Estoque atualizarEstoque(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    public void deletarEstoque(Long id) {
        estoqueRepository.deleteById(id);
    }
}
