package com.livraria.services;

import com.livraria.dto.LivroResponseDTO;
import com.livraria.entities.Livro;
import com.livraria.repositories.LivroRepository;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public LivroResponseDTO adicionarLivro(Livro livro) {
        repository.save(livro);

        return livro.toLivroResponseDTO();
    }
}
