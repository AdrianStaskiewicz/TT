package server.repositories;

import dtos.ConnectionDto;
import entities.Connection;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionRepositoryCustom {

    ConnectionDto getById(Long connectionId);

    Connection saveCustom(Connection connection);

    List<Connection> saveCustom(List<Connection> connections);

    void deleteCustom(Connection connection);

    void deleteCustom(List<Connection> connections);
}
