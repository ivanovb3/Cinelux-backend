package nl.fontys.cinelux.models;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity(name="TICKETS")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private long id;
    @Column(name = "ticket_number", nullable = false)
    private long ticketNumber;
    @ManyToOne(optional = false, targetEntity = User.class)
    @JoinColumn(name = "buyer_id", referencedColumnName = "user_id")
    private User user;
    @ManyToOne(optional = false, targetEntity = Movie.class)
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private Movie movie;
    @Column(name = "seat", nullable = false)
    private String seat;

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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public Ticket() {    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", ticketNumber=" + ticketNumber +
                ", user=" + user +
                ", movie=" + movie +
                ", seat='" + seat + '\'' +
                '}';
    }
}
