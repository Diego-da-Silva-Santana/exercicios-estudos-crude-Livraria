package com.livraria.services;

import com.livraria.dto.LivroRequestDTO;
import com.livraria.dto.LivroResponseDTO;
import com.livraria.entities.Livro;
import com.livraria.exceptions.ResourceNotValidException;
import com.livraria.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;

    public LivroResponseDTO adicionarLivro(LivroRequestDTO requestDTO) {
        if (repository.existsByIsbn(requestDTO.getIsbn())) {
            throw new ResourceNotValidException("O ISBN: " + requestDTO.getIsbn() + " já está cadastrado na base de dados");
        }
        Livro livroRetornado = repository.save(requestDTO.ToLivro());
        LivroResponseDTO livroResponseDTO = new LivroResponseDTO(livroRetornado);

        return livroResponseDTO;
    }
}
