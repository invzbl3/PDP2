package com.company.project.model.valueobject;

import lombok.Data;
import java.util.UUID;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class ProductID {

    private UUID productId;

    public ProductID() {
        this.productId = UUID.randomUUID();
    }

    public ProductID(UUID productId) {
        this.productId = productId;
    }
}