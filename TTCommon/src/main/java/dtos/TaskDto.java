package dtos;

import entities.*;
import enums.TaskCategory;
import enums.TaskPriority;
import enums.TaskStatus;
import enums.TaskType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long id;
    private TaskCategory category;
    private Integer taskNumber;
    private Project project;
    private Release release;
    private String title;
    private String description;
    private TaskType type;
    private TaskPriority priority;
    private TaskStatus status;
    private User assignTo;
    private Double progress;
    private Long estimatedTime;
    private Long spentTime;
    private User createdBy;
    private Date createdDate;
    private Date lastModifiedDate;

    public TaskDto(Task task) {
        this.id = task.getId();
        this.category = task.getCategory();
        this.taskNumber = task.getTaskNumber();
        this.project = task.getProject();
        this.release = task.getRelease();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.type = task.getType();
        this.priority = task.getPriority();
        this.status = task.getStatus();
        this.assignTo = task.getAssignTo();
        this.progress = task.getProgress();
        this.estimatedTime = task.getEstimatedTime();
        this.spentTime = task.getSpentTime();
        this.createdBy = task.getCreatedBy();
        this.createdDate = task.getCreatedDate();
        this.lastModifiedDate = task.getLastModifiedDate();
    }

    public Task toEntity() {
        Task task = new Task();
        task.setId(this.id);
        task.setCategory(this.category);
        task.setTaskNumber(this.taskNumber);
        task.setProject(this.project);
        task.setRelease(this.release);
        task.setTitle(this.title);
        task.setDescription(this.description);
        task.setType(this.type);
        task.setPriority(this.priority);
        task.setStatus(this.status);
        task.setAssignTo(this.assignTo);
        task.setProgress(this.progress);
        task.setEstimatedTime(this.estimatedTime);
        task.setSpentTime(this.spentTime);
        task.setCreatedBy(this.createdBy);
        task.setCreatedDate(this.createdDate);
        task.setLastModifiedDate(this.lastModifiedDate);
        return task;
    }
}
