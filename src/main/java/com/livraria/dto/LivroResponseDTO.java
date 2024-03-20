package com.livraria.dto;

import java.time.LocalDate;

public class LivroResponseDTO {

    private Long id;

    private String titulo;

    private String descricao;

    private LocalDate publicacao;

    private String isbn;

    public LivroResponseDTO() {
    }

    public LivroResponseDTO(Long id,
                            String titulo,
                            String descricao,
                            LocalDate publicacao,
                            String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.publicacao = publicacao;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getPublicacao() {
        return publicacao;
    }

    public String getIsbn() {
        return isbn;
    }


}
