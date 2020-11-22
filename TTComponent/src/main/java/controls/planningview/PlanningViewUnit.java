package controls.planningview;

import lombok.*;

import java.util.List;

@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanningViewUnit {

    private PlanningViewReleaseUnit release;
    private List<PlanningViewPositionUnit> positions;
    //TODO add other values here (time ratio and priority)

    public String toString(){
        return release.getTitle();
    }
}