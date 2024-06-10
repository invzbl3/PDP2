package com.company.project.service;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.company.project.model.entity.BacklogItem;
import com.company.project.repository.BacklogItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BacklogItemService {

    private final BacklogItemRepository backlogItemRepository;

    @Autowired
    public BacklogItemService(BacklogItemRepository backlogItemRepository) {
        this.backlogItemRepository = backlogItemRepository;
    }

    public List<BacklogItem> getAllBacklogItems() {
        return backlogItemRepository.findAll();
    }

    public BacklogItem getBacklogItemById(UUID id) {
        return backlogItemRepository.findById(id).orElse(null);
    }

    public BacklogItem createBacklogItem(BacklogItem backlogItem) {
        return backlogItemRepository.save(backlogItem);
    }

    public BacklogItem updateBacklogItem(UUID id, BacklogItem backlogItem) {
        if (backlogItemRepository.existsById(id)) {
            backlogItem.setId(id);
            return backlogItemRepository.save(backlogItem);
        }
        return null;
    }

    public void deleteBacklogItem(UUID id) {
        backlogItemRepository.deleteById(id);
    }
}