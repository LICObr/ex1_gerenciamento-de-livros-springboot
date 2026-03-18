package com.example.ex1.Ex1.controller;

import com.example.ex1.Ex1.entity.Livro;
import com.example.ex1.Ex1.repository.LivroRepository;
import com.example.ex1.Ex1.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Identifica que eh um Controller
@RequestMapping //mapear as rotas
public class LivroController {

    //injecao de dependencia
    @Autowired //injetar a dependencia ou criando construtor;
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> getALl(){
        return livroService.getALL();
    }

    @PostMapping
    public Livro save(@RequestBody Livro livro){
        return livroService.save(livro);
    }

//coment
}
