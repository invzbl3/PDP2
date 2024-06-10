package com.company.project.model.valueobject;

import lombok.Value;
import java.util.UUID;
import javax.persistence.Embeddable;

@Value
@Embeddable
public class SprintID {
    UUID sprintId;

    public SprintID() {
        this.sprintId = UUID.randomUUID();
    }

    public SprintID(UUID sprintId) {
        this.sprintId = sprintId;
    }
}