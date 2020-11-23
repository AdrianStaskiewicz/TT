package controls.projectview;

import controls.card.CardModel;
import lombok.*;

import java.util.Date;

@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectModel extends CardModel {

    private Date startDate;
    private Date endDate;
    private String description;
    private String company;

    public String toString(){
        return selected + " " + header+" "+description + " " + company;
    }
}