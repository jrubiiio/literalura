package com.jrubiiio.literalura.repository;

import com.jrubiio.literalura.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>{
    /**
     * Busca libros por título.
     *
     * @param titulo Título del libro.
     * @return Lista de libros encontrados.
     */
    List<Libro> findByTituloContainingIgnoreCase(String titulo);

    /**
     * Busca libros por autor.
     *
     * @param autor Autor del libro.
     * @return Lista de libros encontrados.
     */
    List<Libro> findByAutorContainingIgnoreCase(String autor);

    /**
     * Busca libros por idioma.
     *
     * @param idioma Idioma del libro.
     * @return Lista de libros encontrados.
     */
    List<Libro> findByIdiomaContainingIgnoreCase(String idioma);

}
