package com.example.bookmanagement.service;

import com.example.bookmanagement.model.Publisher;
import com.example.bookmanagement.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public void savePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id).orElse(null);
    }

    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }
}