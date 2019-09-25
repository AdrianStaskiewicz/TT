package entities;

import enums.TaskCategory;
import enums.TaskPriority;
import enums.TaskStatus;
import enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TASK_0006")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY")
    private TaskCategory category;
    @Column(name = "TASK_NUMBER")
    private Integer taskNumber;
    @ManyToOne()
    @JoinColumn(name = "PROJECT")
    private Project project;
    @ManyToOne()
    @JoinColumn(name = "RELEASE")
    private Release release;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private TaskType type;
    @Enumerated(EnumType.STRING)
    @Column(name = "PRIORITY")
    private TaskPriority priority;
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private TaskStatus status;
    @ManyToOne()
    @JoinColumn(name = "ASSIGN_TO")
    private User assignTo;
    @Column(name = "PROGRESS")
    private Double progress;
    @Column(name = "ESTIMATED_TIME")
    private Long estimatedTime;
    @Column(name = "SPENT_TIME")
    private Long spentTime;
    @ManyToOne()
    @JoinColumn(name = "CREATED_BY")
    private User createdBy;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "LAST_MODIFIED_DATE")
    private Date lastModifiedDate;

    public String toString() {
        return "";
    }
}
