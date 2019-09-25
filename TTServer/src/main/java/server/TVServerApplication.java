package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "server.repositories")
@EntityScan(basePackages = "entities")
public class TVServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TVServerApplication.class, args);
    }

}

