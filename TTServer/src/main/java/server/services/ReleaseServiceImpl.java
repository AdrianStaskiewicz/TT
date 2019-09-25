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
