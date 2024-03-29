package com.livraria.controller;

import com.livraria.dto.LivroRequestDTO;
import com.livraria.dto.LivroResponseDTO;
import com.livraria.services.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {
    @Autowired
    private LivroService service;

    @PostMapping
    public ResponseEntity<LivroResponseDTO> adicionarLivro(@Valid @RequestBody LivroRequestDTO requestDTO) {
        LivroResponseDTO responseDTO = service.adicionarLivro(requestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(responseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }
}
