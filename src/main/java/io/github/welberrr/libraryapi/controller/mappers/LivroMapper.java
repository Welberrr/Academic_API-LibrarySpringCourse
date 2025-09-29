package io.github.welberrr.libraryapi.controller.mappers;

import io.github.welberrr.libraryapi.controller.dto.CadastroLivroDTO;
import io.github.welberrr.libraryapi.controller.dto.ResultadoPesquisaLivroDTO;
import io.github.welberrr.libraryapi.model.Livro;
import io.github.welberrr.libraryapi.repository.AutorRepository;
import org.hibernate.type.ComponentType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = AutorMapper.class)
public interface LivroMapper {

    @Autowired
    AutorRepository autorRepository = null;

    @Mapping(target = "autor", expression = "java(autorRepository.findById(dto.idAutor()).orElse(null) )")
    Livro toEntity(CadastroLivroDTO dto);

    public abstract ResultadoPesquisaLivroDTO toDTO(Livro livro);
}
