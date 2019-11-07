package server.repositories;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dtos.ReleaseDto;
import entities.QRelease;
import entities.Release;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
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
    public List<ReleaseDto> getAllUpcomingAssignedToProjectByProjectId(Long projectId) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QRelease release = QRelease.release;
        Date currentDate = new Date();

        return (List<ReleaseDto>) query.select(Projections.constructor(ReleaseDto.class, release.release))
                .from(release)
                .where(release.project.id.eq(projectId)
                        .and(release.releaseDate.isNull())
                        .and(release.archived.isNull().or(release.archived.isFalse())))
                .fetch();
    }

    @Override
    public List<ReleaseDto> getAllReleasedAssignedToProjectByProjectId(Long projectId) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QRelease release = QRelease.release;
        Date currentDate = new Date();

        return (List<ReleaseDto>) query.select(Projections.constructor(ReleaseDto.class, release.release))
                .from(release)
                .where(release.project.id.eq(projectId)
                        .and(release.releaseDate.isNotNull())
                        .and(release.archived.isNull().or(release.archived.isFalse())))
                .fetch();
    }


    @Override
    public List<ReleaseDto> getAllArchivedAssignedToProjectByProjectId(Long projectId) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QRelease release = QRelease.release;

        return (List<ReleaseDto>) query.select(Projections.constructor(ReleaseDto.class, release.release))
                .from(release)
                .where(release.project.id.eq(projectId)
                        .and(release.archived.eq(Boolean.TRUE)))
                .fetch();
    }

    @Override
    public Boolean checkReleaseVersionNumberAvailabilityForProjectByProjectId(Integer majorNumber, Integer minorNumber, Integer releaseNumber, Integer buildNumber, Long projectId) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QRelease release = QRelease.release;

        List<Release> releases = query.select(release)
                .from(release)
                .where(release.majorNumber.eq(majorNumber)
                        .and(release.minorNumber.eq(minorNumber))
                        .and(release.releaseNumber.eq(releaseNumber))
                        .and(release.buildNumber.eq(buildNumber))
                        .and(release.project.id.eq(projectId)))
                .fetch();

        return releases.isEmpty();
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
