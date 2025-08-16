package io.github.welberrr.libraryapi.repository;

import io.github.welberrr.libraryapi.model.Autor;
import io.github.welberrr.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {

    List<Livro> findByAuto(Autor autor);
    List<Livro> findByTitulo(String titulo);
    List<Livro> findByISBN(String titulo);
    List<Livro> findByDataPublicacaoBetween(LocalDate inicio, LocalDate fim);
    List<Livro> findByTituloLike(String titulo);
}
