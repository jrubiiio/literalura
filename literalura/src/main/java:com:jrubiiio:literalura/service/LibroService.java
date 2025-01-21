package com.jrubiiio.literalura.service;

import com.jrubiio.literalura.entity.Libro;
import com.jrubiiio.literalura.repository.LibroRepository;
import com.jrubiiio.literalura.util.GutendexAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    private final LibroRepository libroRepository;
    private final GutendexAPI gutendexAPI;

    @Autowired
    public LibroService(LibroRepository libroRepository, GutendexAPI gutendexAPI) {
        this.libroRepository = libroRepository;
        this.gutendexAPI = gutendexAPI;
    }

    /**
     * Obtiene todos los libros desde la base de datos.
     *
     * @return Lista de libros.
     */
    public List<Libro> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }

    /**
     * Guarda una lista de libros en la base de datos.
     */
    public void guardarLibros() {
        List<Libro> libros = gutendexAPI.obtenerLibros();
        libroRepository.saveAll(libros);
    }

    /**
     * Busca libros por título.
     *
     * @param titulo Título del libro.
     * @return Lista de libros encontrados.
     */
    public List<Libro> buscarPorTitulo(String titulo) {
        return libroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    /**
     * Busca libros por autor.
     *
     * @param autor Autor del libro.
     * @return Lista de libros encontrados.
     */
    public List<Libro> buscarPorAutor(String autor) {
        return libroRepository.findByAutorContainingIgnoreCase(autor);
    }

    /**
     * Busca libros por idioma.
     *
     * @param idioma Idioma del libro.
     * @return Lista de libros encontrados.
     */
    public List<Libro> buscarPorIdioma(String idioma) {
        return libroRepository.findByIdiomaContainingIgnoreCase(idioma);
    }
}
}


