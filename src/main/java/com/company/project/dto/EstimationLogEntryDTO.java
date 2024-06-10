package com.company.project.dto;

import lombok.Data;
import java.util.Date;

@Data
public class EstimationLogEntryDTO {
    private Date date;
    private int estimatedHours;
    private String notes;
}