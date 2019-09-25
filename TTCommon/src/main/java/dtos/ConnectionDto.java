package dtos;

import entities.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionDto {
    private Long id;
    private Company company;
    private User worker;

    public ConnectionDto(Connection connection) {
        this.id = connection.getId();
        this.company = connection.getCompany();
        this.worker = connection.getWorker();
    }

    public Connection toEntity() {
        Connection connection = new Connection();
        connection.setId(this.id);
        connection.setCompany(this.company);
        connection.setWorker(this.worker);
        return connection;
    }
}
