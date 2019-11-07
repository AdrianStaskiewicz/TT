package entities;

import enums.TargetReleaseDateType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RELEASE_0005")
public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "PROJECT")
    private Project project;
    @Column(name = "MAJOR_NUMBER")
    private Integer majorNumber;
    @Column(name = "MINOR_NUMBER")
    private Integer minorNumber;
    @Column(name = "RELEASE_NUMBER")
    private Integer releaseNumber;
    @Column(name = "BUILD_NUMBER")
    private Integer buildNumber;
    @Column(name = "NAME")
    private String name;
    @Column(name = "FOCUS")
    private String focus;
    @Column(name = "RELEASE_DATE")
    private Date releaseDate;
    @Column(name = "ARCHIVED")
    private Boolean archived;
    @Enumerated(EnumType.STRING)
    @Column(name = "TARGET_RELEASE_DATE_TYPE")
    private TargetReleaseDateType targetReleaseDateType;
    @Column(name = "TARGET_RELEASE_DATE_TIME")
    private Date targetReleaseDateTime;

    public String toString() {
        return "";
    }
}
