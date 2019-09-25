package server.services;

import dtos.ConnectionDto;
import entities.Connection;

import java.util.List;

public interface ConnectionService {

    ConnectionDto getById(Long connectionId);

    Connection save(Connection connection);

    List<Connection> save(List<Connection> connections);

    void delete(Connection connection);

    void delete(List<Connection> connections);
}
