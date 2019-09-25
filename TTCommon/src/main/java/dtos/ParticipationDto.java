package dtos;

import entities.*;
import enums.RoleType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ParticipationDto {
    private Long id;
    private Project project;
    private User contributor;
    private RoleType role;
    private String description;

    public ParticipationDto(Participation participation) {
        this.id = participation.getId();
        this.project = participation.getProject();
        this.contributor = participation.getContributor();
        this.role = participation.getRole();
        this.description = participation.getDescription();
    }

    public Participation toEntity() {
        Participation participation = new Participation();
        participation.setId(this.id);
        participation.setProject(this.project);
        participation.setContributor(this.contributor);
        participation.setRole(this.role);
        participation.setDescription(this.description);
        return participation;
    }
}
