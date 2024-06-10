package com.company.project.model.aggregate;

import lombok.Data;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import com.company.project.model.entity.BacklogItem;

@Data
@Entity
@NoArgsConstructor
public class Backlog {

    @Id
    @Column(columnDefinition = "VARCHAR(255)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "backlog")
    private List<BacklogItem> backlogItems;

    public Backlog(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}