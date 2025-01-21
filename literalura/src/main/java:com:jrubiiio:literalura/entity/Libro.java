package com.jrubiiio.literalura.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String idioma;
    private String enlace; // URL al libro
}