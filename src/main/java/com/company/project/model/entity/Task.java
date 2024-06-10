package com.company.project.model.entity;

import lombok.Data;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import com.company.project.model.valueobject.EstimationLogEntry;

@Data
@Entity
@NoArgsConstructor
public class Task {

    @Id
    @Column(columnDefinition = "VARCHAR(255)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;
    @Column
    private String description;
    @Column
    private int hoursRemaining;
    @Column
    private String volunteer;

    @ManyToOne
    @JoinColumn(name = "backlog_item_id", columnDefinition = "VARCHAR(255)")
    private BacklogItem backlogItem;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EstimationLogEntry> estimationLogEntries;

    public Task(UUID id, String name, String description, int hoursRemaining, String volunteer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hoursRemaining = hoursRemaining;
        this.volunteer = volunteer;
    }
}