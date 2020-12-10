package nl.fontys.cinelux.resources;


import nl.fontys.cinelux.models.Projection;
import nl.fontys.cinelux.models.Ticket;
import nl.fontys.cinelux.models.User;
import nl.fontys.cinelux.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")  //http://localhost:3000
@RestController
@RequestMapping("/tickets")
public class TicketResources {
     @Autowired
    private TicketRepository ticketRepository;

    @GetMapping("/all")
    public Iterable<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    @PostMapping("/add")
    public @ResponseBody
    String addNewTicket(@RequestBody Ticket ticket){
        ticketRepository.save(ticket);
        return "Successfully bought ticket for " + ticket.getProjection().getMovie().getName();
    }

    @GetMapping("/findById")
    public Ticket getTicketById(@RequestParam long id){
        if(ticketRepository.existsById(id)){
            return ticketRepository.findById(id).get();
        }
        return null;
    }
    @GetMapping("/findByProjection")
    public Iterable<Ticket> getTicketsByProjection(@RequestParam Projection p){
        return ticketRepository.findByProjection(p);
    }
    @GetMapping("/findByUser")
    public Iterable<Ticket> getTicketsByUser(@RequestParam User u){
        return ticketRepository.findByUser(u);
    }
}
