package controls.taskview;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskUnit {

    private int id;
    private String description;
    private String person;
    private Double progress;

    public String toString(){
        return description + " " + person + " " +progress;
    }
}