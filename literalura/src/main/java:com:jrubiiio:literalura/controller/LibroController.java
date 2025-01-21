package com.jrubiiio.literalura.controller;

import com.jrubiio.literalura.entity.Libro;
import com.jrubiiio.literalura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class LibroController {

    @Autowired
    private LibroService libroService;

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Listar todos los libros");
            System.out.println("2. Buscar por título");
            System.out.println("3. Buscar por autor");
            System.out.println("4. Buscar por idioma");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    listarLibros();
                    break;
                case 2:
                    buscarPorTitulo();
                    break;
                case 3:
                    buscarPorAutor();
                    break;
                case 4:
                    buscarPorIdioma();
                    break;
                case 5:
                    System.out.println("Saliendo del catálogo...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private void listarLibros() {
        List<Libro> libros = libroService.obtenerTodosLosLibros();
        libros.forEach(libro -> {
            System.out.println("ID: " + libro.getId());
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Idioma: " + libro.getIdioma());
            System.out.println("--------------------------");
        });
    }

    private void buscarPorTitulo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        List<Libro> libros = libroService.buscarPorTitulo(titulo);
        libros.forEach(libro -> {
            System.out.println("ID: " + libro.getId());
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Idioma: " + libro.getIdioma());
            System.out.println("--------------------------");
        });
    }

    private void buscarPorAutor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        List<Libro> libros = libroService.buscarPorAutor(autor);
        libros.forEach(libro -> {
            System.out.println("ID: " + libro.getId());
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Idioma: " + libro.getIdioma());
            System.out.println("--------------------------");
        });
    }

    private void buscarPorIdioma() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el idioma del libro: ");
        String idioma = scanner.nextLine();
        List<Libro> libros = libroService.buscarPorIdioma(idioma);
        libros.forEach(libro -> {
            System.out.println("ID: " + libro.getId());
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Idioma: " + libro.getIdioma());
            System.out.println("--------------------------");
        });
    }
}
}

