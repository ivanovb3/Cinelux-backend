package nl.fontys.cinelux.models;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity(name = "TICKETS")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private long id;
    @Column(name = "ticket_number", nullable = false)
    private long ticketNumber;
    @ManyToOne(optional = false, targetEntity = User.class)
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    private User user;
    @ManyToOne(optional = false, targetEntity = Projection.class)
    @JoinColumn(name = "projection_id", referencedColumnName = "projection_id")
    private Projection projection;
    @Column(name = "seat", nullable = false)
    private String seat;

    public Ticket() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(long ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Projection getProjection() {
        return projection;
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", ticketNumber=" + ticketNumber +
                ", user=" + user +
                ", projection=" + projection +
                ", seat='" + seat + '\'' +
                '}';
    }
}
