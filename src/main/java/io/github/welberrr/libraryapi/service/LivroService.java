package io.github.welberrr.libraryapi.service;

import io.github.welberrr.libraryapi.model.Livro;
import io.github.welberrr.libraryapi.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository repository;

    public Livro salvar(Livro livro){
       return repository.save(livro);
    }
}
