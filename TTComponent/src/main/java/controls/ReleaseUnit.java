package controls;

import lombok.*;

import java.util.Date;

@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReleaseUnit {

    private int id;
    private Boolean select;
    private String title;
    private Date startDate;
    private Date endDate;
    private String description;
    private String company;

    public String toString(){
        return select + " " + title+" "+description + " " + company;
    }
}