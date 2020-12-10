package nl.fontys.cinelux.repository;

import nl.fontys.cinelux.models.Projection;
import nl.fontys.cinelux.models.Ticket;
import nl.fontys.cinelux.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {

    List<Ticket> findByProjection(Projection projection);

    List<Ticket> findByUser(User user);
}
