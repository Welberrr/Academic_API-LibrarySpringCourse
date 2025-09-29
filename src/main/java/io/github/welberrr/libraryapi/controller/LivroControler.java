package io.github.welberrr.libraryapi.controller;

import io.github.welberrr.libraryapi.controller.dto.CadastroLivroDTO;
import io.github.welberrr.libraryapi.controller.dto.ErroResposta;
import io.github.welberrr.libraryapi.controller.dto.ResultadoPesquisaLivroDTO;
import io.github.welberrr.libraryapi.controller.mappers.LivroMapper;
import io.github.welberrr.libraryapi.exceptions.RegistroDuplicadoException;
import io.github.welberrr.libraryapi.model.Livro;
import io.github.welberrr.libraryapi.service.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class LivroControler implements GenericController {

    private final LivroService service;
    private final LivroMapper mapper;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid CadastroLivroDTO dto) {
        Livro livro = mapper.toEntity(dto);
        service.salvar(livro);
        var url = gerarHeaderLocation(livro.getId());
        return ResponseEntity.created(url).build();
    }

    public ResponseEntity<ResultadoPesquisaLivroDTO> obterDetalhes(
            @PathVariable("id") String id){
        return service.obterPorId(UUID.fromString(id)).map(livro -> {
            var dto = mapper.toDTO(livro);
            return ResponseEntity.ok(dto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
