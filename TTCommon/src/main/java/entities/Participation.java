package entities;

import enums.RoleType;
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
@Table(name = "PARTICIPATION_0003")
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "PROJECT")
    private Project project;
    @ManyToOne()
    @JoinColumn(name = "CONTRIBUTOR")
    private User contributor;
    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    private RoleType role;
    @Column(name = "DESCRIPTION")
    private String description;

    public String toString() {
        return "";
    }
}
