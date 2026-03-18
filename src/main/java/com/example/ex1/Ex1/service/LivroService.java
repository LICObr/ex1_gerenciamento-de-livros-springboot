package com.example.ex1.Ex1.service;

import com.example.ex1.Ex1.entity.Livro;
import com.example.ex1.Ex1.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    //injetar
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    //listar
    public List<Livro> getALL(){
        return livroRepository.findAll();
    }
    //criar
    public Livro save(Livro livro){
        return livroRepository.save(livro);
    }
    //deletar
    public void delete(Long id){
        livroRepository.deleteById(id);
    }

}
