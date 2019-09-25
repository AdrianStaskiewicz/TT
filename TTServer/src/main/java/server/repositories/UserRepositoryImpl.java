package server.repositories;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dtos.UserDto;
import entities.User;
import entities.QUser;
import others.LoginPack;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepositoryCustom {

    @Inject
    private EntityManager em;

    @Override
    public UserDto getById(Long userId) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QUser user = QUser.user;

        UserDto result = (UserDto) query.select(Projections.constructor(UserDto.class,user.user))
                .from(user)
                .where(user.id.eq(userId))
                .fetchOne();

        return result;
    }

    @Override
    public User saveCustom(User user) {
        user = em.merge(user);
        em.flush();

        return user;
    }

    @Override
    public List<User> saveCustom(List<User> users) {
        List<User> result = new ArrayList<>();

        for (User e : users) {
            result.add(em.merge(e));
        }
        em.flush();

        return result;
    }

    @Override
    public void deleteCustom(User user) {
        em.remove(em.contains(user) ? user : em.merge(user));
    }

    @Override
    public void deleteCustom(List<User> users) {
        for (User e : users) {
            em.remove(em.contains(e) ? e : em.merge(e));
        }
    }

    @Override
    public Long getUserIdByLoginAndPassword(LoginPack loginPack) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QUser user = QUser.user;

        return query.select(user.id)
                .from(user)
                .where(user.login.eq(loginPack.getLogin()).and(user.password.eq(loginPack.getPassword())))
                .fetchOne();
    }
}
