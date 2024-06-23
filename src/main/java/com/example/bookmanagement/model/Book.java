package com.example.bookmanagement.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String author;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    // Getters and setters
}