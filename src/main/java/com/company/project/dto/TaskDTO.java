package com.company.project.dto;

import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
public class TaskDTO {
    private UUID id;
    private String name;
    private String volunteer;
    private String description;
    private int hoursRemaining;
    private List<EstimationLogEntryDTO> estimationLogEntries;
}