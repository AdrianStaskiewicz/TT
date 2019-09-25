package server.repositories;

import com.querydsl.jpa.impl.JPAQueryFactory;
import dtos.ConnectionDto;
import entities.Connection;
import entities.QConnection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ConnectionRepositoryImpl implements ConnectionRepositoryCustom {

    @Inject
    private EntityManager em;

    @Override
    public ConnectionDto getById(Long connectionId) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QConnection connection = QConnection.connection;

        ConnectionDto result = (ConnectionDto) query.select(connection)
                .from(connection)
                .where(connection.id.eq(connectionId))
                .fetch();

        return result;
    }

    @Override
    public Connection saveCustom(Connection connection) {
        connection = em.merge(connection);
        em.flush();

        return connection;
    }

    @Override
    public List<Connection> saveCustom(List<Connection> connections) {
        List<Connection> result = new ArrayList<>();

        for (Connection e : connections) {
            result.add(em.merge(e));
        }
        em.flush();

        return result;
    }

    @Override
    public void deleteCustom(Connection connection) {
        em.remove(em.contains(connection) ? connection : em.merge(connection));
    }

    @Override
    public void deleteCustom(List<Connection> connections) {
        for (Connection e : connections) {
            em.remove(em.contains(e) ? e : em.merge(e));
        }
    }
}
