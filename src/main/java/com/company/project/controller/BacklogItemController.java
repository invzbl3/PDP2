package com.company.project.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.company.project.model.entity.BacklogItem;
import com.company.project.service.BacklogItemService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/backlogItems")
public class BacklogItemController {

    private final BacklogItemService backlogItemService;

    @Autowired
    public BacklogItemController(BacklogItemService backlogItemService) {
        this.backlogItemService = backlogItemService;
    }

    @GetMapping
    public List<BacklogItem> getAllBacklogItems() {
        return backlogItemService.getAllBacklogItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BacklogItem> getBacklogItemById(@PathVariable UUID id) {
        BacklogItem backlogItem = backlogItemService.getBacklogItemById(id);
        return ResponseEntity.ok(backlogItem);
    }

    @PostMapping
    public ResponseEntity<BacklogItem> createBacklogItem(@RequestBody BacklogItem backlogItem) {
        BacklogItem createdBacklogItem = backlogItemService.createBacklogItem(backlogItem);
        return ResponseEntity.ok(createdBacklogItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BacklogItem> updateBacklogItem(@PathVariable UUID id, @RequestBody BacklogItem backlogItem) {
        BacklogItem updatedBacklogItem = backlogItemService.updateBacklogItem(id, backlogItem);
        return ResponseEntity.ok(updatedBacklogItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBacklogItem(@PathVariable UUID id) {
        backlogItemService.deleteBacklogItem(id);
        return ResponseEntity.noContent().build();
    }
}