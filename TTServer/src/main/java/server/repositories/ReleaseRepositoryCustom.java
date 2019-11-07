package server.repositories;

import dtos.ReleaseDto;
import entities.Release;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReleaseRepositoryCustom{

    ReleaseDto getById(Long releaseId);

    List<ReleaseDto> getAllUpcomingAssignedToProjectByProjectId(Long projectId);

    List<ReleaseDto> getAllReleasedAssignedToProjectByProjectId(Long projectId);

    List<ReleaseDto> getAllArchivedAssignedToProjectByProjectId(Long projectId);

    Boolean checkReleaseVersionNumberAvailabilityForProjectByProjectId(Integer majorNumber, Integer minorNumber, Integer releaseNumber, Integer buildNumber, Long projectId);

    Release saveCustom(Release release);

    List<Release> saveCustom(List<Release> releases);

    void deleteCustom(Release release);

    void deleteCustom(List<Release> releases);
}
