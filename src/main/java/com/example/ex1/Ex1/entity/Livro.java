package com.example.ex1.Ex1.entity;

import jakarta.persistence.*;

@Entity(name = "Livro") //Indica entity
@Table(name="tb_livro")   //Tabela banco
public class Livro {

    @Id //Identifica que eh um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gera valores automaticamente, para n precisar
    //fazer 1, 2, 3, 4 ...
    private Long id;

    @Column(name="titulo_livro")
    private String titulo;

    @Column(name="nome_autor")
    private String autor;

    private Integer anoPublicacao;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
