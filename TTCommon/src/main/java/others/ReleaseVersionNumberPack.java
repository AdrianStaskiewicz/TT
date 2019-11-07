package others;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ReleaseVersionNumberPack {

    @Getter
    @Setter
    private Integer majorNumber;
    @Getter
    @Setter
    private Integer minorNumber;
    @Getter
    @Setter
    private Integer releaseNumber;
    @Getter
    @Setter
    private Integer buildNumber;
    @Getter
    @Setter
    private Long projectId;
}
