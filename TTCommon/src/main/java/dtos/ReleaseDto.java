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
    private Date releaseDate;
    private Boolean archived;
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
        this.releaseDate = release.getReleaseDate();
        this.archived = release.getArchived();
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
        release.setReleaseDate(this.releaseDate);
        release.setArchived(this.archived);
        release.setTargetReleaseDateType(this.targetReleaseDateType);
        release.setTargetReleaseDateTime(this.targetReleaseDateTime);
        return release;
    }

    public String toString(){
        return name;
    }

    public String getReleaseNumberToString(){
        if(this.majorNumber!=null&&this.minorNumber!=null&&this.releaseNumber!=null&&this.buildNumber!=null){
            return this.majorNumber.toString()+"."
                    +this.minorNumber.toString()+"."
                    +this.releaseNumber.toString()+"."
                    +this.buildNumber.toString();
        }

        return "";
    }
}
