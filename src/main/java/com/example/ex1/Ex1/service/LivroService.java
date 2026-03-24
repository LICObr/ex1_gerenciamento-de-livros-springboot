package com.example.ex1.Ex1.service;

import com.example.ex1.Ex1.entity.Livro;
import com.example.ex1.Ex1.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    //injetar
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    //listar
    public List<Livro> findAll(){
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

    //buscar por id
    public Optional<Livro> buscar(Long id){
        return livroRepository.findById(id);
    }

    //atualizar
    public Livro update(Long id, Livro livro){
        livro.setId(id);
        return livroRepository.save(livro);
    }

    //teste

}
