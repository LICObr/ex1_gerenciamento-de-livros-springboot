package com.example.ex1.Ex1.controller;

import com.example.ex1.Ex1.entity.Livro;
import com.example.ex1.Ex1.repository.LivroRepository;
import com.example.ex1.Ex1.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Livro>> findAll(){
        List<Livro> resquest = livroService.findAll();
        return ResponseEntity.ok().body(resquest);
    }


    @PostMapping
    public Livro save(@RequestBody Livro livro){
        return livroService.save(livro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        livroService.delete(id);
    }

//coment
}
