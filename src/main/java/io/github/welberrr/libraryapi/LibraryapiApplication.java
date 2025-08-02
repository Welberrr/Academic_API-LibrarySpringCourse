package io.github.welberrr.libraryapi;

import io.github.welberrr.libraryapi.model.Autor;
import io.github.welberrr.libraryapi.repository.AutorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class LibraryapiApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(LibraryapiApplication.class, args);
		AutorRepository repository = context.getBean(AutorRepository.class);

		exemploSalvarRegistro(repository);
	}

	public static void exemploSalvarRegistro(@org.jetbrains.annotations.NotNull AutorRepository autorRepository){
		Autor autor = new Autor();
		autor.setNome("Welber");
		autor.setNacionalidade("Brasileiro");
		autor.setDataNascimento(LocalDate.of(2004, 9, 25));

		var autorSalvo = autorRepository.save(autor);
		System.out.printf("Autor Salvo: " + autorSalvo);
	}
}
