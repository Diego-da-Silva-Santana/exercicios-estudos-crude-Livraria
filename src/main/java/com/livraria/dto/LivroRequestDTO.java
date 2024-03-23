package com.livraria.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.livraria.entities.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.ISBN;

import java.time.LocalDate;

public class LivroRequestDTO {

    @NotBlank(message = "O título não pode estar em branco")
    @Size(max = 100, message = "O título deve ter no máximo 100 caracteres")
    private String titulo;

    @NotBlank
    @Size(max = 4000, message = "O título deve ter no máximo 100 caracteres")
    private String descricao;

    @NotNull(message = "A data de publicação não pode ser nula")
    @Past(message = "A data de publicação deve ser uma data passada")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate publicacao;

    @NotBlank(message = "O ISBN não pode estar em branco")
    @Size(min = 10, max = 13, message = "O ISBN deve ter entre 10 e 13 caracteres")
    @ISBN(message = "O ISBN não é válido")
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
