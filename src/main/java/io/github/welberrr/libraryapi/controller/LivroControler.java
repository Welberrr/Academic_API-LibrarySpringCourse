package io.github.welberrr.libraryapi.controller;

import io.github.welberrr.libraryapi.controller.dto.CadastroLivroDTO;
import io.github.welberrr.libraryapi.controller.dto.ErroResposta;
import io.github.welberrr.libraryapi.controller.mappers.LivroMapper;
import io.github.welberrr.libraryapi.exceptions.RegistroDuplicadoException;
import io.github.welberrr.libraryapi.model.Livro;
import io.github.welberrr.libraryapi.service.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class LivroControler {

    private final LivroService service;
    private final LivroMapper mapper;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid CadastroLivroDTO dto){
        try {
            Livro livro = mapper.toEntity(dto);
            return ResponseEntity.ok(dto);
        } catch (RegistroDuplicadoException e){
            var erroDTO = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }
}
