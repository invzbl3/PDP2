package com.company.project.controller;

import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.company.project.service.BacklogService;
import com.company.project.model.aggregate.Backlog;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/backlogs")
public class BacklogController {
    private final BacklogService backlogService;

    @Autowired
    public BacklogController(BacklogService backlogService) {
        this.backlogService = backlogService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Backlog> getBacklogById(@PathVariable UUID id) {
        return backlogService.getBacklogById(id)
                .map(backlog -> new ResponseEntity<>(backlog, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Backlog> createBacklog(@RequestBody Backlog backlog) {
        Backlog createdBacklog = backlogService.createBacklog(backlog);
        return new ResponseEntity<>(createdBacklog, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBacklog(@PathVariable UUID id) {
        if (backlogService.getBacklogById(id).isPresent()) {
            backlogService.deleteBacklog(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}