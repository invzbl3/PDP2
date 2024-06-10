package com.company.project.service;

import java.util.UUID;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.company.project.model.aggregate.Backlog;
import com.company.project.repository.BacklogRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BacklogService {
    private final BacklogRepository backlogRepository;

    @Autowired
    public BacklogService(BacklogRepository backlogRepository) {
        this.backlogRepository = backlogRepository;
    }

    public Optional<Backlog> getBacklogById(UUID id) {
        return backlogRepository.findById(id);
    }

    public Backlog createBacklog(Backlog backlog) {
        return backlogRepository.save(backlog);
    }

    public void deleteBacklog(UUID id) {
        backlogRepository.deleteById(id);
    }
}