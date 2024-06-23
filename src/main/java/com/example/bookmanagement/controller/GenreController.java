package com.example.bookmanagement.controller;

import com.example.bookmanagement.model.Genre;
import com.example.bookmanagement.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping
    public String listGenres(Model model) {
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("genres", genres);
        return "genres/list";
    }

    @GetMapping("/add")
    public String showAddForm(Genre genre) {
        return "genres/add";
    }

    @PostMapping("/add")
    public String addGenre(@Valid Genre genre, BindingResult result) {
        if (result.hasErrors()) {
            return "genres/add";
        }
        genreService.saveGenre(genre);
        return "redirect:/genres";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        Genre genre = genreService.getGenreById(id);
        if (genre == null) {
            return "404";
        }
        model.addAttribute("genre", genre);
        return "genres/edit";
    }

    @PostMapping("/update/{id}")
    public String updateGenre(@PathVariable("id") long id, @Valid Genre genre, BindingResult result, Model model) {
        if (result.hasErrors()) {
            genre.setId(id);
            return "genres/edit";
        }
        genreService.saveGenre(genre);
        return "redirect:/genres";
    }

    @GetMapping("/delete/{id}")
    public String deleteGenre(@PathVariable("id") long id) {
        genreService.deleteGenre(id);
        return "redirect:/genres";
    }
}