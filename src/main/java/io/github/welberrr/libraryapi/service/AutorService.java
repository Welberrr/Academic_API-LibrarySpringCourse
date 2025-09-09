package io.github.welberrr.libraryapi.service;

import io.github.welberrr.libraryapi.exceptions.OperacaoNaoPermitidaEception;
import io.github.welberrr.libraryapi.model.Autor;
import io.github.welberrr.libraryapi.repository.AutorRepository;
import io.github.welberrr.libraryapi.repository.LivroRepository;
import io.github.welberrr.libraryapi.validator.AutorValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository repository;
    private final AutorValidator validator;
    private final LivroRepository livroRepository;

    public Autor salvar(Autor autor){
        validator.validar(autor);
        return repository.save(autor);
    }

    public void Atualizar(Autor autor){
        if(autor.getId() == null){
            throw new IllegalArgumentException("Para atualizar, e necessario que o autor esteja na base");
        }
        validator.validar(autor);
        repository.save(autor);
    }

    public Optional<Autor> obterPorId(UUID id){
        return repository.findById(id);
    }

    public void deletar(Autor autor){
        if(possuiLivro(autor)){
            throw new OperacaoNaoPermitidaEception("Nao eh permitido excluir um autor que tenha livros cadastrados!");
        }
        repository.delete(autor);
    }


    public List<Autor> pesquisa(String nome, String nacionalidade){
        if(nome != null && nacionalidade != null){
            return repository.findByNomeAndNacionalidade(nome, nacionalidade);
        }

        if(nome != null){
            return repository.findByNome(nome);
        }

        if(nacionalidade != null){
            return repository.findByNacionalidade(nacionalidade);
        }

        return repository.findAll();
    }

    public boolean possuiLivro(Autor autor){
        return livroRepository.existsByAutor(autor);
    }
}
