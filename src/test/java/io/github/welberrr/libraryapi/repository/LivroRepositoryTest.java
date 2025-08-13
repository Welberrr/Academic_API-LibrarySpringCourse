package io.github.welberrr.libraryapi.repository;

import io.github.welberrr.libraryapi.model.Autor;
import io.github.welberrr.libraryapi.model.GeneroLivro;
import io.github.welberrr.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarTest(){
        Livro livro = new Livro();

        livro.setIsbn("12345");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("UFO");
        livro.setDataPublicacao(LocalDate.of(1980, 1, 2));

        Autor autor = autorRepository.findById(UUID.fromString(";aslkdjf;aslkjf")).orElse(null);

        livro.setAutor(autor);

        repository.save(livro);
    }

    @Test
    void salvarCascadeTest(){
        Livro livro = new Livro();

        livro.setIsbn("12345");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("UFO");
        livro.setDataPublicacao(LocalDate.of(1980, 1, 2));

        Autor autor = new Autor();
        autor.setNome("Joao");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNascimento(LocalDate.of(2004, 9, 25));

        //Autor autor = autorRepository.findById(UUID.fromString(";aslkdjf;aslkjf")).orElse(null);

        livro.setAutor(autor);

        repository.save(livro);
    }

    @Test
    void atualizarAutorDolivro(){
        UUID id = UUID.fromString("teste");
        var livroParaAtualizar = repository.findById(id).orElse(null);

        UUID idAutor = UUID.fromString("teste");
        Autor maria = autorRepository.findById(idAutor).orElse(null);

        livroParaAtualizar.setAutor(maria);

        repository.save(livroParaAtualizar);
    }

    @Test
    void deletar(){
        UUID id = UUID.fromString("teste");
        repository.deleteById(id);
    }

    @Test
    void deletarCascade(){
        UUID id = UUID.fromString("teste");
        repository.deleteById(id);
    }
}