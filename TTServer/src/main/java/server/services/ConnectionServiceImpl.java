package server.services;

import dtos.ConnectionDto;
import entities.Connection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.repositories.ConnectionRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Service for Connection
 */
@Service
@RequiredArgsConstructor
public class ConnectionServiceImpl implements ConnectionService {

    @Inject
    ConnectionRepository connectionRepository;

    @Override
    public ConnectionDto getById(Long connectionId) {
        return connectionRepository.getById(connectionId);
    }

    @Override
    public Connection save(Connection connection) {
        return connectionRepository.saveCustom(connection);
    }

    @Override
    public List<Connection> save(List<Connection> connections) {
        return connectionRepository.saveCustom(connections);
    }

    @Override
    public void delete(Connection connection) {
        connectionRepository.deleteCustom(connection);
    }

    @Override
    public void delete(List<Connection> connections) {
        connectionRepository.deleteCustom(connections);
    }
}
