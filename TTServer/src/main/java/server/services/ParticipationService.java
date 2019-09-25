package server.services;

import dtos.ParticipationDto;
import entities.Participation;

import java.util.List;

public interface ParticipationService {

    ParticipationDto getById(Long participationId);

    Participation save(Participation participation);

    List<Participation> save(List<Participation> participations);

    void delete(Participation participation);

    void delete(List<Participation> participations);
}
