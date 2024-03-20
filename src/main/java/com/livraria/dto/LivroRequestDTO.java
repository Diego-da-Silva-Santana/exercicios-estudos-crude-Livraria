package com.livraria.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.livraria.entities.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.ISBN;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LivroRequestDTO {

    @NotBlank
    @Size(max = 200)
    private String titulo;
    @Size(max = 4000)
    @NotBlank
    private String descricao;
    @NotNull
    @Past
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate publicacao;
    @NotBlank
    @ISBN
    private String isbn;

    public LivroRequestDTO() {
    }

    public LivroRequestDTO(String titulo,
                           String descricao,
                           LocalDate publicacao,
                           String isbn) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.publicacao = publicacao;
        this.isbn = isbn;
    }

    public Livro ToLivro() {
        return new Livro(titulo, descricao, publicacao, isbn);
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
