package com.company.project.model.entity;

import lombok.Data;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import com.company.project.model.aggregate.Backlog;
import com.company.project.model.valueobject.SprintID;
import com.company.project.model.valueobject.ProductID;
import com.company.project.model.valueobject.ReleaseID;

@Data
@Entity
@NoArgsConstructor
public class BacklogItem {

    @Id
    @Column(columnDefinition = "VARCHAR(255)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String status;
    @Column
    private String story;
    @Column
    private int storyPoints;
    @Column
    private String summary;
    @Column
    private String type;

    @Embedded
    private ProductID productID;
    @Embedded
    private ReleaseID releaseID;
    @Embedded
    private SprintID sprintID;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks;

    @ManyToOne
    private Backlog backlog;

    public BacklogItem(UUID id, String status, String story, int storyPoints,
                       String summary, String type, ProductID productID,
                       ReleaseID releaseID, SprintID sprintID) {
        this.id = id;
        this.status = status;
        this.story = story;
        this.storyPoints = storyPoints;
        this.summary = summary;
        this.type = type;
        this.productID = productID;
        this.releaseID = releaseID;
        this.sprintID = sprintID;
    }
}