package server.repositories;

import entities.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends JpaRepository<Release,Long>,ReleaseRepositoryCustom{

}
