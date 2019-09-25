package controls;

import lombok.*;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanningUnit {

    private int id;
    private Boolean select;
    private String description;
    private String person;
    private Double progress;

    public String toString(){
        return select + " " + description + " " + person + " " +progress;
    }
}