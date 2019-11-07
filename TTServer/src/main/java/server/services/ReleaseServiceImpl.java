package server.services;

import dtos.ReleaseDto;
import entities.Release;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.repositories.ReleaseRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Service for Release
 */
@Service
@RequiredArgsConstructor
public class ReleaseServiceImpl implements ReleaseService {

    @Inject
    ReleaseRepository releaseRepository;

    @Override
    public ReleaseDto getById(Long releaseId) {
        return releaseRepository.getById(releaseId);
    }

    @Override
    public List<ReleaseDto> getAllUpcomingAssignedToProjectByProjectId(Long projectId) {
        return releaseRepository.getAllUpcomingAssignedToProjectByProjectId(projectId);
    }

    @Override
    public List<ReleaseDto> getAllReleasedAssignedToProjectByProjectId(Long projectId) {
        return releaseRepository.getAllReleasedAssignedToProjectByProjectId(projectId);
    }

    @Override
    public List<ReleaseDto> getAllArchivedAssignedToProjectByProjectId(Long projectId) {
        return releaseRepository.getAllArchivedAssignedToProjectByProjectId(projectId);
    }

    @Override
    public Boolean checkReleaseVersionNumberAvailabilityForProjectByProjectId(Integer majorNumber, Integer minorNumber, Integer releaseNumber, Integer buildNumber, Long projectId) {
        return releaseRepository.checkReleaseVersionNumberAvailabilityForProjectByProjectId(majorNumber, minorNumber, releaseNumber, buildNumber, projectId);
    }

    @Override
    public Release save(Release release) {
        return releaseRepository.saveCustom(release);
    }

    @Override
    public List<Release> save(List<Release> releases) {
        return releaseRepository.saveCustom(releases);
    }

    @Override
    public void delete(Release release) {
        releaseRepository.deleteCustom(release);
    }

    @Override
    public void delete(List<Release> releases) {
        releaseRepository.deleteCustom(releases);
    }
}
