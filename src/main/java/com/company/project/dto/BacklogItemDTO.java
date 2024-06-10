package com.company.project.dto;

import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
public class BacklogItemDTO {
    private UUID id;
    private String status;
    private String story;
    private int storyPoints;
    private String summary;
    private String type;
    private String productId;
    private String releaseId;
    private String sprintId;
    private List<TaskDTO> tasks;
}