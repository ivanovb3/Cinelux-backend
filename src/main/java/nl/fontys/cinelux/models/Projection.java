package nl.fontys.cinelux.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "PROJECTIONS")
public class Projection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projection_id")
    private long id;
    @ManyToOne(optional = false, targetEntity = Movie.class)
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private Movie movie;
    @OneToMany(mappedBy = "projection")
    private List<Ticket> tickets;
    @Column(name = "projection_date", nullable = false)
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Projection() {    }

    @Override
    public String toString() {
        return "Projection{" +
                "id=" + id +
                ", movie=" + movie +
                ", tickets=" + tickets +
                ", date=" + date +
                '}';
    }
}
