package controls.taskview;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskUnit {

    private Long id;
    private String title;
    private String person;
    private Double progress;

    public String toString(){
        return title + " " + person + " " +progress;
    }
}