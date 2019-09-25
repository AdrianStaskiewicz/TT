package server.repositories;

import dtos.ParticipationDto;
import entities.Participation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipationRepositoryCustom{

    ParticipationDto getById(Long participationId);

    Participation saveCustom(Participation participation);

    List<Participation> saveCustom(List<Participation> participations);

    void deleteCustom(Participation participation);

    void deleteCustom(List<Participation> participations);
}
