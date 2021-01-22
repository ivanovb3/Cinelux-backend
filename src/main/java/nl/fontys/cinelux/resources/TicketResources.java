package nl.fontys.cinelux.resources;


import nl.fontys.cinelux.models.Projection;
import nl.fontys.cinelux.models.Ticket;
import nl.fontys.cinelux.models.User;
import nl.fontys.cinelux.repository.TicketRepository;
import nl.fontys.cinelux.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin("*")  //http://localhost:3000
@RestController
@RequestMapping("/api/tickets")
public class TicketResources {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/all")
    public Iterable<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    @PostMapping("/add")
    public @ResponseBody
    String addNewTicket(@RequestBody Ticket ticket) {
        ticketRepository.save(ticket);
        return "Successfully bought ticket for " + ticket.getProjection().getMovie().getName();
    }

    @GetMapping("/findById")
    public Ticket getTicketById(@RequestParam long id, String request) {
        if (ticketRepository.existsById(id)) {
            if (ticketRepository.findById(id).get().getUser().getUsername().equals(jwtUtils.getUserNameFromJwtToken(request))) {
                return ticketRepository.findById(id).get();
            } else {
                return null;
            }
        }
        return null;
    }

    @GetMapping("/findByProjection")
    public Iterable<Ticket> getTicketsByProjection(@RequestParam Projection p) {
        return ticketRepository.findByProjection(p);
    }

    @GetMapping("/findByUser")
    public Iterable<Ticket> getTicketsByUser(@RequestParam User u, String request) {
        if (ticketRepository.findByUser(u).size() != 0) {
            if (ticketRepository.findByUser(u).get(0).getUser().getUsername().equals(jwtUtils.getUserNameFromJwtToken(request))) {
                return ticketRepository.findByUser(u);
            } else {
                return null;
            }
        }
        return null;
    }
}
