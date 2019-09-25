package server.repositories;

import com.querydsl.jpa.impl.JPAQueryFactory;
import dtos.CommentDto;
import entities.Comment;
import entities.QComment;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepositoryCustom {

    @Inject
    private EntityManager em;

    @Override
    public CommentDto getById(Long commentId) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QComment comment = QComment.comment1;

        CommentDto result = (CommentDto) query.select(comment)
                .from(comment)
                .where(comment.id.eq(commentId))
                .fetch();

        return result;
    }

    @Override
    public Comment saveCustom(Comment comment) {
        comment = em.merge(comment);
        em.flush();

        return comment;
    }

    @Override
    public List<Comment> saveCustom(List<Comment> comments) {
        List<Comment> result = new ArrayList<>();

        for (Comment e : comments) {
            result.add(em.merge(e));
        }
        em.flush();

        return result;
    }

    @Override
    public void deleteCustom(Comment comment) {
        em.remove(em.contains(comment) ? comment : em.merge(comment));
    }

    @Override
    public void deleteCustom(List<Comment> comments) {
        for (Comment e : comments) {
            em.remove(em.contains(e) ? e : em.merge(e));
        }
    }
}
