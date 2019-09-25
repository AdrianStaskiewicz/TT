package server.services;

import dtos.ReleaseDto;
import entities.Release;

import java.util.List;

public interface ReleaseService {

    ReleaseDto getById(Long releaseId);

    Release save(Release release);

    List<Release> save(List<Release> releases);

    void delete(Release release);

    void delete(List<Release> releases);
}
