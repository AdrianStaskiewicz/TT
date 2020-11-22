package controls.planningview;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanningViewPositionUnit {

    private Long id;
    private Boolean isSelected;
    private String title;
    private String person;
    private Double progress;
    //TODO add other values here (time ratio and priority)

    public String toString(){
        return isSelected + " " + title + " " + person + " " +progress;
    }
}