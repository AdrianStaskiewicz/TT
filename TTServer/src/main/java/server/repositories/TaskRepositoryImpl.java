package server.repositories;

import com.querydsl.jpa.impl.JPAQueryFactory;
import dtos.TaskDto;
import entities.QTask;
import entities.Task;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepositoryCustom {

    @Inject
    private EntityManager em;

    @Override
    public TaskDto getById(Long taskId) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QTask task = QTask.task;

        TaskDto result = (TaskDto) query.select(task)
                .from(task)
                .where(task.id.eq(taskId))
                .fetch();

        return result;
    }

    @Override
    public Task saveCustom(Task task) {
        task = em.merge(task);
        em.flush();

        return task;
    }

    @Override
    public List<Task> saveCustom(List<Task> tasks) {
        List<Task> result = new ArrayList<>();

        for (Task e : tasks) {
            result.add(em.merge(e));
        }
        em.flush();

        return result;
    }

    @Override
    public void deleteCustom(Task task) {
        em.remove(em.contains(task) ? task : em.merge(task));
    }

    @Override
    public void deleteCustom(List<Task> tasks) {
        for (Task e : tasks) {
            em.remove(em.contains(e) ? e : em.merge(e));
        }
    }
}
