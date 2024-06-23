package com.example.bookmanagement.service;

import com.example.bookmanagement.model.Genre;
import com.example.bookmanagement.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public void saveGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public Genre getGenreById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }
}