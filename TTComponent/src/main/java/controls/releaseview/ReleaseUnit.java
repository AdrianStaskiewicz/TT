package controls.releaseview;

import lombok.*;

import java.util.Date;

@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReleaseUnit {

    private int id;
    private String number;

    private String name;
    private Date date;
    private String focus;

    private Boolean select;

    public String toString(){
        return select + " " + number+" "+name + " " + focus;
    }
}