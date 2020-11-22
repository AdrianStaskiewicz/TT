package controls.planningview;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanningViewReleaseUnit {

    private Long id;
    private String title;

    //TODO add other values here (release date, spend and estimated time)

    public String toString(){
        return title;
    }
}