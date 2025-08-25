package io.github.welberrr.libraryapi.service;

import io.github.welberrr.libraryapi.model.Autor;
import io.github.welberrr.libraryapi.repository.AutorRepository;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository){
        this.repository = repository;
    }

    public Autor salvar(Autor autor){
        return repository.save(autor);
    }
}
