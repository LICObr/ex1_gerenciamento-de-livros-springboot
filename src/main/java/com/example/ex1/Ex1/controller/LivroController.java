package com.example.ex1.Ex1.controller;

import com.example.ex1.Ex1.entity.Livro;
import com.example.ex1.Ex1.repository.LivroRepository;
import com.example.ex1.Ex1.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController //Identifica que eh um Controller
@RequestMapping("/livros") //mapear as rotas
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
    public ResponseEntity<Livro> save(@RequestBody Livro livro){
        Livro save = livroService.save(livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(livro.getId())
                .toUri();
        return ResponseEntity.created(uri).body(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id){
        return livroService.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livro){
        return ResponseEntity.ok(livroService.update(id, livro));
    }

//coment
}
