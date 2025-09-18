package io.github.welberrr.libraryapi.controller.dto;

import io.github.welberrr.libraryapi.model.GeneroLivro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.ISBN;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CadastroLivroDTO(@ISBN @NotBlank(message = "Campo Obrigatorio!") String isbn, @NotBlank(message = "Campo Obrigatorio!") String titulo, @NotNull(message = "Campo Obrigatorio!") LocalDate dataPublicacao, GeneroLivro genero, BigDecimal preco, @NotNull(message = "Campo Obrigatorio!") UUID idAutor) {
}
