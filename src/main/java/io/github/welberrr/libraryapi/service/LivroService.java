package io.github.welberrr.libraryapi.service;

import io.github.welberrr.libraryapi.model.Livro;
import io.github.welberrr.libraryapi.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.spel.ast.OpInc;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository repository;

    public Livro salvar(Livro livro){
       return repository.save(livro);
    }

    public Optional<Livro> obterPorId(UUID id){
        return repository.findById(id);
    }

    public void deletar(Livro livro){
        repository.delete(livro);
    }
}
