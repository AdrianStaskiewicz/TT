package server.services;

import dtos.ParticipationDto;
import entities.Participation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.repositories.ParticipationRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Service for Participation
 */
@Service
@RequiredArgsConstructor
public class ParticipationServiceImpl implements ParticipationService {

    @Inject
    ParticipationRepository participationRepository;

    @Override
    public ParticipationDto getById(Long participationId) {
        return participationRepository.getById(participationId);
    }

    @Override
    public Participation save(Participation participation) {
        return participationRepository.saveCustom(participation);
    }

    @Override
    public List<Participation> save(List<Participation> participations) {
        return participationRepository.saveCustom(participations);
    }

    @Override
    public void delete(Participation participation) {
        participationRepository.deleteCustom(participation);
    }

    @Override
    public void delete(List<Participation> participations) {
        participationRepository.deleteCustom(participations);
    }
}
