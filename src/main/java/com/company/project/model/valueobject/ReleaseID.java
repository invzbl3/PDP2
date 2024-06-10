package com.company.project.model.valueobject;

import lombok.Value;
import java.util.UUID;
import javax.persistence.Embeddable;

@Value
@Embeddable
public class ReleaseID {
    UUID releaseId;

    public ReleaseID() {
        this.releaseId = UUID.randomUUID();
    }

    public ReleaseID(UUID releaseId) {
        this.releaseId = releaseId;
    }
}