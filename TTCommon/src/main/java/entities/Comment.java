package entities;

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
@Table(name = "COMMENT_0007")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "TASK")
    private Task task;
    @ManyToOne()
    @JoinColumn(name = "COMMENTATOR")
    private User commentator;
    @Column(name = "COMMENT")
    private String comment;
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    public String toString() {
        return "";
    }
}
