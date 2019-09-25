package server.repositories;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dtos.ProjectDto;
import entities.Project;
import entities.QConnection;
import entities.QParticipation;
import entities.QProject;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepositoryCustom {

    @Inject
    private EntityManager em;

    @Override
    public ProjectDto getById(Long projectId) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QProject project = QProject.project;

        ProjectDto result = (ProjectDto) query.select(project)
                .from(project)
                .where(project.id.eq(projectId))
                .fetch();

        return result;
    }

    @Override
    public List<ProjectDto> getAllAssignedToUserByUserId(Long userId) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QProject project = QProject.project;
        QParticipation participation = QParticipation.participation;

        return (List<ProjectDto>) query.select(Projections.constructor(ProjectDto.class, project.project))
                .from(project)
                .leftJoin(participation)
                .on(participation.project.id.eq(project.id))
                .where(participation.contributor.id.eq(userId))
                .fetch();
    }

    @Override
    public List<ProjectDto> getAllActiveAssignedToUserByUserId(Long userId) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QProject project = QProject.project;
        QParticipation participation = QParticipation.participation;
        Date currentDate = new Date();

        return (List<ProjectDto>) query.select(Projections.constructor(ProjectDto.class, project.project))
                .from(project)
                .leftJoin(participation)
                .on(participation.project.id.eq(project.id))
                .where(project.startDate.before(currentDate)
                        .and(project.endDate.after(currentDate).or(project.endDate.isNull()))
                        .and(participation.contributor.id.eq(userId)))
                .fetch();
    }

    @Override
    public List<ProjectDto> getAllUpcomingAssignedToUserByUserId(Long userId) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QProject project = QProject.project;
        QParticipation participation = QParticipation.participation;
        Date currentDate = new Date();

        return (List<ProjectDto>) query.select(Projections.constructor(ProjectDto.class, project.project))
                .from(project)
                .leftJoin(participation)
                .on(participation.project.id.eq(project.id))
                .where(project.startDate.after(currentDate)
                        .and(participation.contributor.id.eq(userId)))
                .fetch();
    }

    @Override
    public List<ProjectDto> getAllEndedAssignedToUserByUserId(Long userId) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QProject project = QProject.project;
        QParticipation participation = QParticipation.participation;
        Date currentDate = new Date();

        return (List<ProjectDto>) query.select(Projections.constructor(ProjectDto.class, project.project))
                .from(project)
                .leftJoin(participation)
                .on(participation.project.id.eq(project.id))
                .where(project.endDate.before(currentDate)
                        .and(participation.contributor.id.eq(userId)))
                .fetch();
    }

    @Override
    public ProjectDto getFirstAssignedToUserByUserId(Long userId) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QProject project = QProject.project;
        QParticipation participation = QParticipation.participation;

        return query.select(Projections.constructor(ProjectDto.class, project.project))
                .from(project.project)
                .leftJoin(participation)
                .on(participation.project.id.eq(project.id))
                .where(participation.contributor.id.eq(userId))
                .fetchFirst();
    }

    @Override
    public Project saveCustom(Project project) {
        project = em.merge(project);
        em.flush();

        return project;
    }

    @Override
    public List<Project> saveCustom(List<Project> projects) {
        List<Project> result = new ArrayList<>();

        for (Project e : projects) {
            result.add(em.merge(e));
        }
        em.flush();

        return result;
    }

    @Override
    public void deleteCustom(Project project) {
        em.remove(em.contains(project) ? project : em.merge(project));
    }

    @Override
    public void deleteCustom(List<Project> projects) {
        for (Project e : projects) {
            em.remove(em.contains(e) ? e : em.merge(e));
        }
    }
}
