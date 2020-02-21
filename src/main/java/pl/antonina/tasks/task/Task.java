package pl.antonina.tasks.task;

import lombok.Data;
import pl.antonina.tasks.parent.Parent;

import javax.persistence.*;

@Entity
@Table(name="tasks")
@Data
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Parent parent;
    private String name;
    private String description;
    private Integer points;
}
