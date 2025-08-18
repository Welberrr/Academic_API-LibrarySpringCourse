package io.github.welberrr.libraryapi.service;

import io.github.welberrr.libraryapi.model.Autor;
import io.github.welberrr.libraryapi.model.GeneroLivro;
import io.github.welberrr.libraryapi.model.Livro;
import io.github.welberrr.libraryapi.repository.AutorRepository;
import io.github.welberrr.libraryapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class TransacaoService {
    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    public void salvarLivroComFoto(){
        
    }

    @Transactional
    public void atualizacaoSemAtualizar(){
        var livro = livroRepository.findById(UUID.fromString("a;sdlkfja;lskf")).orElse(null);

        livro.setDataPublicacao(LocalDate.of(2025, 06, 02));
    }

    @Transactional
    public void executar(){

            Livro livro = new Livro();

            Autor autor = autorRepository.findById(UUID.fromString(";aslkdjf;aslkjf")).orElse(null);
            livro.setAutor(autor);
            autorRepository.save(autor);

            livro.setIsbn("12345");
            livro.setPreco(BigDecimal.valueOf(100));
            livro.setGenero(GeneroLivro.FICCAO);
            livro.setTitulo("UFO");
            livro.setDataPublicacao(LocalDate.of(1980, 1, 2));

            livroRepository.saveAndFlush(livro);

            if(autor.getNome().equals("Welber")){
                throw new RuntimeException("Rollback!");
            }
        }
    }
