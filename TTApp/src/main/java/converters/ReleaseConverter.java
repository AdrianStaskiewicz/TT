package converters;

import controls.projectview.ProjectUnit;
import controls.releaseview.ReleaseUnit;
import dtos.ProjectDto;
import dtos.ReleaseDto;

public class ReleaseConverter {

    public static ReleaseUnit dtoToUnit(ReleaseDto releaseDto){
        String number = releaseDto.getMajorNumber().toString()+"."
        +releaseDto.getMinorNumber().toString()+"."
        +releaseDto.getBuildNumber().toString()+"."
        +releaseDto.getReleaseNumber().toString();
        return ReleaseUnit.builder()
                .select(Boolean.FALSE)
                .number(number)
                .name(releaseDto.getName())
                .focus(releaseDto.getFocus())
                .date(releaseDto.getTargetReleaseDateTime())
                .build();
    }
}
