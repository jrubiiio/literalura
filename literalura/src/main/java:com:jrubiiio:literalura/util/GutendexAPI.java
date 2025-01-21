package com.jrubiiio.literalura.util;


import com.jrubiio.literalura.entity.Libro;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class GutendexAPI {
    private static final String API_URL = "https://gutendex.com/books/";

    public List<Libro> obtenerLibros() {
        List<Libro> libros = new ArrayList<>();
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == 200) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(connection.getInputStream());

                root.get("results").forEach(book -> {
                    Libro libro = new Libro();
                    libro.setTitulo(book.get("title").asText());
                    libro.setAutor(book.get("authors").get(0).get("name").asText());
                    libro.setIdioma(book.get("languages").get(0).asText());
                    libro.setEnlace(book.get("formats").get("text/html").asText());
                    libros.add(libro);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return libros;
    }
}
