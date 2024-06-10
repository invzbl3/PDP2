package com.company.project.repository;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.company.project.model.entity.BacklogItem;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BacklogItemRepository extends JpaRepository<BacklogItem, UUID> {
}