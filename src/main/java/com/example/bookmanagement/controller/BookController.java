package com.example.bookmanagement.controller;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.model.Genre;
import com.example.bookmanagement.model.Publisher;
import com.example.bookmanagement.service.BookService;
import com.example.bookmanagement.service.GenreService;
import com.example.bookmanagement.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public String listBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books/list";
    }

    @GetMapping("/add")
    public String showAddForm(Book book, Model model) {
        model.addAttribute("genres", genreService.getAllGenres());
        model.addAttribute("publishers", publisherService.getAllPublishers());
        return "books/add";
    }

    @PostMapping("/add")
    public String addBook(@Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("genres", genreService.getAllGenres());
            model.addAttribute("publishers", publisherService.getAllPublishers());
            return "books/add";
        }
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return "404";
        }
        model.addAttribute("book", book);
        model.addAttribute("genres", genreService.getAllGenres());
        model.addAttribute("publishers", publisherService.getAllPublishers());
        return "books/edit";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") long id, @Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            book.setId(id);
            model.addAttribute("genres", genreService.getAllGenres());
            model.addAttribute("publishers", publisherService.getAllPublishers());
            return "books/edit";
        }
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}