package io.github.welberrr.libraryapi.repository;

import io.github.welberrr.libraryapi.model.Autor;
import io.github.welberrr.libraryapi.model.GeneroLivro;
import io.github.welberrr.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID>, JpaSpecificationExecutor<Livro> {

    List<Livro> findByAuto(Autor autor);
    List<Livro> findByTitulo(String titulo);
    List<Livro> findByISBN(String titulo);
    List<Livro> findByDataPublicacaoBetween(LocalDate inicio, LocalDate fim);
    List<Livro> findByTituloLike(String titulo);

    @Query("select l from Livro as l order by l.titulo, l.preco")
    List<Livro> listarTodosOrdenadoPorTituloAndPreco();

    @Query("select a from Livro l join l.autor a")
    List<Autor> listarAutoresDosLivros();

    @Query("select distinct l l.titulo from Livro l")
    List<String> listarNomeDiferentesLivros();

    @Query("""
            select l.genero
            from Livro l
            join l.autor a
            where a.nacionalidade = 'Brasileira'
            order by l.genero
            """)
    List<String> listarGenerosAutoresBrasileiros();

    @Query("select l from Livro l where l.genero = :genero order by :paramOrdenacao")
    List<Livro> findByGenero(@Param("genero") GeneroLivro generoLivro, @Param("paramOrdenacao") String nomePropriedade);

    @Query("select l from Livro l where l.genero = ?1 order by ?2")
    List<Livro> findByGeneroPositionalParameters(GeneroLivro generoLivro, String nomePropriedade);

    @Modifying
    @Transactional
    @Query ("delete from Livro where genero = ?1")
    void deleteByGenero(GeneroLivro genero);

    @Modifying
    @Transactional
    @Query ("update Livro set dataPublicacao = ?1")
    void updateDataPublicacao(LocalDate novaData);


    boolean existsByAutor(Autor autor);

    Optional<Livro> findById(UUID id);
}
