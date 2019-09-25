package entities;

import enums.Language;
import enums.Location;
import enums.TimeZone;
import enums.UserType;
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
@Table(name = "USER_0002")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "DISPLAY_NAME")
    private String displayName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "STATUS")
    private Boolean status;
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private UserType type;
    @ManyToOne()
    @JoinColumn(name = "COMPANY")
    private Company company;
    @Enumerated(EnumType.STRING)
    @Column(name = "LANGUAGE")
    private Language language;
    @Enumerated(EnumType.STRING)
    @Column(name = "LOCATION")
    private Location location;
    @Enumerated(EnumType.STRING)
    @Column(name = "TIME_ZONE")
    private TimeZone timeZone;
    @Column(name = "REGISTERED_DATE")
    private Date registeredDate;
    @Column(name = "LAST_ACTIVITY_DATE")
    private Date lastActivityDate;

    public String toString() {
        return "";
    }
}
