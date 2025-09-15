package io.github.welberrr.libraryapi.controller.dto;

import io.github.welberrr.libraryapi.model.Autor;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record AutorDTO(java.util.UUID id, @NotBlank(message = "Campo Obrigatorio") @Size(min = 2, max = 100, message = "Campo fora do tamanho padrao") String nome, @NotNull(message = "Campo Obrigatorio") @Past(message = "nao pode ser uma data futura") LocalDate dataNascimento, @NotBlank(message = "Campo Obrigatorio") @Size(max = 50, min = 2, message = "Campo fora do tamanho padrao") String nacionalidade) {

    public Autor mapearParaAutor(){
        Autor autor = new Autor();
        autor.setNome(this.nome);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);
        return autor;
    }
}