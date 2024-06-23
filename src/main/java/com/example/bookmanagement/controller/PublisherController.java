package com.example.bookmanagement.controller;

import com.example.bookmanagement.model.Publisher;
import com.example.bookmanagement.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/publishers")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public String listPublishers(Model model) {
        List<Publisher> publishers = publisherService.getAllPublishers();
        model.addAttribute("publishers", publishers);
        return "publishers/list";
    }

    @GetMapping("/add")
    public String showAddForm(Publisher publisher) {
        return "publishers/add";
    }

    @PostMapping("/add")
    public String addPublisher(@Valid Publisher publisher, BindingResult result) {
        if (result.hasErrors()) {
            return "publishers/add";
        }
        publisherService.savePublisher(publisher);
        return "redirect:/publishers";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        Publisher publisher = publisherService.getPublisherById(id);
        if (publisher == null) {
            return "404";
        }
        model.addAttribute("publisher", publisher);
        return "publishers/edit";
    }

    @PostMapping("/update/{id}")
    public String updatePublisher(@PathVariable("id") long id, @Valid Publisher publisher, BindingResult result, Model model) {
        if (result.hasErrors()) {
            publisher.setId(id);
            return "publishers/edit";
        }
        publisherService.savePublisher(publisher);
        return "redirect:/publishers";
    }

    @GetMapping("/delete/{id}")
    public String deletePublisher(@PathVariable("id") long id) {
        publisherService.deletePublisher(id);
        return "redirect:/publishers";
    }
}