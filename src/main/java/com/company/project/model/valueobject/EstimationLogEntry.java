package com.company.project.model.valueobject;

import lombok.Data;
import java.util.UUID;
import javax.persistence.*;
import com.company.project.model.entity.Task;

@Data
@Entity
public class EstimationLogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String description;
    private int hoursRemaining;
    private String volunteer;

    @ManyToOne
    private Task task;

    public EstimationLogEntry() {}

    public EstimationLogEntry(String name, String description,
                              int hoursRemaining, String volunteer) {
        this.name = name;
        this.description = description;
        this.hoursRemaining = hoursRemaining;
        this.volunteer = volunteer;
    }

    public EstimationLogEntry(UUID id, String name, String description,
                              int hoursRemaining, String volunteer, Task task) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hoursRemaining = hoursRemaining;
        this.volunteer = volunteer;
        this.task = task;
    }
}