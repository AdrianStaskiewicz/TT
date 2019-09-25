package dtos;

import entities.*;
import enums.TargetReleaseDateType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReleaseDto {
    private Long id;
    private Project project;
    private Integer majorNumber;
    private Integer minorNumber;
    private Integer releaseNumber;
    private Integer buildNumber;
    private String name;
    private String focus;
    private TargetReleaseDateType targetReleaseDateType;
    private Date targetReleaseDateTime;

    public ReleaseDto(Release release) {
        this.id = release.getId();
        this.project = release.getProject();
        this.majorNumber = release.getMajorNumber();
        this.minorNumber = release.getMinorNumber();
        this.releaseNumber = release.getReleaseNumber();
        this.buildNumber = release.getBuildNumber();
        this.name = release.getName();
        this.focus = release.getFocus();
        this.targetReleaseDateType = release.getTargetReleaseDateType();
        this.targetReleaseDateTime = release.getTargetReleaseDateTime();
    }

    public Release toEntity() {
        Release release = new Release();
        release.setId(this.id);
        release.setProject(this.project);
        release.setMajorNumber(this.majorNumber);
        release.setMinorNumber(this.minorNumber);
        release.setReleaseNumber(this.releaseNumber);
        release.setBuildNumber(this.buildNumber);
        release.setName(this.name);
        release.setFocus(this.focus);
        release.setTargetReleaseDateType(this.targetReleaseDateType);
        release.setTargetReleaseDateTime(this.targetReleaseDateTime);
        return release;
    }
}
