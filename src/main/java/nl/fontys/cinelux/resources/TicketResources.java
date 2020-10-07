package nl.fontys.cinelux.resources;


import nl.fontys.cinelux.models.Ticket;
import nl.fontys.cinelux.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketResources {
    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping
    public Iterable<Ticket> getTickets(){
        return ticketRepository.findAll();
    }
}
