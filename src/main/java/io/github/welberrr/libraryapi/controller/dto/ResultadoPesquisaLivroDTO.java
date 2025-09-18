package io.github.welberrr.libraryapi.controller.dto;

import io.github.welberrr.libraryapi.model.GeneroLivro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ResultadoPesquisaLivroDTO(UUID id, String isbn, String titulo, LocalDate dataPublicacao, GeneroLivro genero, BigDecimal precom, AutorDTO autor) {
}
