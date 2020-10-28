package nl.fontys.cinelux.repository;

import nl.fontys.cinelux.models.Projection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectionRepository extends CrudRepository<Projection, Long> {
}
