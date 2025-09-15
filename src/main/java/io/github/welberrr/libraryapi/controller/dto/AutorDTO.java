package io.github.welberrr.libraryapi.controller.dto;

import io.github.welberrr.libraryapi.model.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AutorDTO(java.util.UUID id, @NotBlank(message = "Campo Obrigatorio") String nome, @NotNull(message = "Campo Obrigatorio") LocalDate dataNascimento, @NotBlank(message = "Campo Obrigatorio") String nacionalidade) {

    public Autor mapearParaAutor(){
        Autor autor = new Autor();
        autor.setNome(this.nome);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);
        return autor;
    }
}
