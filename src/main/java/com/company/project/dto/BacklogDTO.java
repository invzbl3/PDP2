package com.company.project.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class BacklogDTO {
    private UUID id;
    private String name;
    private String description;
}