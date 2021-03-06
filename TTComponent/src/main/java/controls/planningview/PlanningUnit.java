package controls.planningview;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanningUnit {

    private Long id;
    private Boolean select;
    private String title;
    private String person;
    private Double progress;

    public String toString(){
        return select + " " + title + " " + person + " " +progress;
    }
}