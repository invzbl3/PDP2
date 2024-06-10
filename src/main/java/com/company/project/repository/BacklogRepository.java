package com.company.project.repository;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.company.project.model.aggregate.Backlog;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog, UUID> {
}