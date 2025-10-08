package io.github.welberrr.libraryapi.service;

import io.github.welberrr.libraryapi.model.GeneroLivro;
import io.github.welberrr.libraryapi.model.Livro;
import io.github.welberrr.libraryapi.repository.LivroRepository;
import io.github.welberrr.libraryapi.repository.specs.LivroSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.expression.spel.ast.OpInc;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Livro> pesquisa(String isbn, String titulo, String nome, GeneroLivro genero, Integer anoPublicacao){

        Specification<Livro> specs = Specification.where(LivroSpecs.isbnEqual(isbn).and(LivroSpecs.tituloLike(titulo)).and(LivroSpecs.generoEqual(genero)));

        Specification<Livro> specs = Specification.where((root, query, cb) -> cb.conjunction() );

        if (isbn != null){
            specs = specs.and(LivroSpecs.isbnEqual(isbn));
        }

        if (titulo != null){
            specs = specs.and(LivroSpecs.tituloLike(titulo));
        }

        if (genero != null){
            specs = specs.and(LivroSpecs.generoEqual(genero));
        }

        return repository.findAll(LivroSpecs.isbnEqual(isbn));
    }
}
