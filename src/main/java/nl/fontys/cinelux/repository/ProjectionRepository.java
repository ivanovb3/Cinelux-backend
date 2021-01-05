package nl.fontys.cinelux.repository;

import nl.fontys.cinelux.models.Movie;
import nl.fontys.cinelux.models.Projection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProjectionRepository extends CrudRepository<Projection, Long> {
    List<Projection> findByDateAndMovie(Date date, Movie movie);

    List<Projection> findByDate(Date date);

    List<Projection> findAll();
}
