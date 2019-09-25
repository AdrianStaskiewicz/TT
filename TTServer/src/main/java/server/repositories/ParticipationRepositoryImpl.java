package server.repositories;

import com.querydsl.jpa.impl.JPAQueryFactory;
import dtos.ParticipationDto;
import entities.Participation;
import entities.QParticipation;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ParticipationRepositoryImpl implements ParticipationRepositoryCustom {

    @Inject
    private EntityManager em;

    @Override
    public ParticipationDto getById(Long participationId) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QParticipation participation = QParticipation.participation;

        ParticipationDto result = (ParticipationDto) query.select(participation)
                .from(participation)
                .where(participation.id.eq(participationId))
                .fetch();

        return result;
    }

    @Override
    public Participation saveCustom(Participation participation) {
        participation = em.merge(participation);
        em.flush();

        return participation;
    }

    @Override
    public List<Participation> saveCustom(List<Participation> participations) {
        List<Participation> result = new ArrayList<>();

        for (Participation e : participations) {
            result.add(em.merge(e));
        }
        em.flush();

        return result;
    }

    @Override
    public void deleteCustom(Participation participation) {
        em.remove(em.contains(participation) ? participation : em.merge(participation));
    }

    @Override
    public void deleteCustom(List<Participation> participations) {
        for (Participation e : participations) {
            em.remove(em.contains(e) ? e : em.merge(e));
        }
    }
}
