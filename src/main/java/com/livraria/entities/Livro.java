package com.livraria.entities;

import com.livraria.dto.LivroResponseDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tb_livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    private LocalDate publicacao;

    private String isbn;

    public Livro() {
    }

    public Livro(String titulo,
                 String descricao,
                 LocalDate publicacao,
                 String isbn) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.publicacao = publicacao;
        this.isbn = isbn;
    }

    public LivroResponseDTO toLivroResponseDTO(){
        return  new LivroResponseDTO(id, titulo, descricao, publicacao, isbn);
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
