package com.jrubiiio.literalura;

import com.jrubiiio.literalura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private LibroService libroService;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Opción para cargar libros desde API al iniciar la aplicación
		libroService.guardarLibros();
		System.out.println("Libros cargados exitosamente desde Gutenberg.");
	}
}

}
