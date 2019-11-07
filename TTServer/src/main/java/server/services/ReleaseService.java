package server.services;

import dtos.ReleaseDto;
import entities.Release;

import java.util.List;

public interface ReleaseService {

    ReleaseDto getById(Long releaseId);

    List<ReleaseDto> getAllUpcomingAssignedToProjectByProjectId(Long projectId);

    List<ReleaseDto> getAllReleasedAssignedToProjectByProjectId(Long projectId);

    List<ReleaseDto> getAllArchivedAssignedToProjectByProjectId(Long projectId);

    Boolean checkReleaseVersionNumberAvailabilityForProjectByProjectId(Integer majorNumber, Integer minorNumber, Integer releaseNumber, Integer buildNumber, Long projectId);

    Release save(Release release);

    List<Release> save(List<Release> releases);

    void delete(Release release);

    void delete(List<Release> releases);
}
