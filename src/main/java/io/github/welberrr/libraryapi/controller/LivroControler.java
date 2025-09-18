package io.github.welberrr.libraryapi.controller;

import io.github.welberrr.libraryapi.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class LivroControler {

    private final LivroService service;
}
