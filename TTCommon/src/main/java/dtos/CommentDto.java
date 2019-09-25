package dtos;

import entities.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Long id;
    private Task task;
    private User commentator;
    private String comment;
    private Date createdDate;

    public CommentDto(Comment comment) {
        this.id = comment.getId();
        this.task = comment.getTask();
        this.commentator = comment.getCommentator();
        this.comment = comment.getComment();
        this.createdDate = comment.getCreatedDate();
    }

    public Comment toEntity() {
        Comment comment = new Comment();
        comment.setId(this.id);
        comment.setTask(this.task);
        comment.setCommentator(this.commentator);
        comment.setComment(this.comment);
        comment.setCreatedDate(this.createdDate);
        return comment;
    }
}
