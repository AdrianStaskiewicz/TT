package server.repositories;

import com.querydsl.jpa.impl.JPAQueryFactory;
import dtos.ReleaseDto;
import entities.QRelease;
import entities.Release;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ReleaseRepositoryImpl implements ReleaseRepositoryCustom {

    @Inject
    private EntityManager em;

    @Override
    public ReleaseDto getById(Long releaseId) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QRelease release = QRelease.release;

        ReleaseDto result = (ReleaseDto) query.select(release)
                .from(release)
                .where(release.id.eq(releaseId))
                .fetch();

        return result;
    }

    @Override
    public Release saveCustom(Release release) {
        release = em.merge(release);
        em.flush();

        return release;
    }

    @Override
    public List<Release> saveCustom(List<Release> releases) {
        List<Release> result = new ArrayList<>();

        for (Release e : releases) {
            result.add(em.merge(e));
        }
        em.flush();

        return result;
    }

    @Override
    public void deleteCustom(Release release) {
        em.remove(em.contains(release) ? release : em.merge(release));
    }

    @Override
    public void deleteCustom(List<Release> releases) {
        for (Release e : releases) {
            em.remove(em.contains(e) ? e : em.merge(e));
        }
    }
}
