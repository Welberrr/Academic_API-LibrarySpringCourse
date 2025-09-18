package io.github.welberrr.libraryapi.controller.mappers;

import io.github.welberrr.libraryapi.controller.dto.AutorDTO;
import io.github.welberrr.libraryapi.model.Autor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AutorMapper {
    @Mapping(source = "nome", target = "nomeAutor")
    Autor toEntity(AutorDTO dto);

    AutorDTO toDTO(Autor autor);
}
