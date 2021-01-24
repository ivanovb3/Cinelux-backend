package nl.fontys.cinelux.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "PROJECTIONS")
public class Projection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projection_id")
    private long id;

    @JsonIgnoreProperties("projections")
    @ManyToOne(optional = false, targetEntity = Movie.class)
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")     //
    private Movie movie;


    @OneToMany(mappedBy = "projection")
    private List<Ticket> tickets;
    @Temporal(TemporalType.DATE)
    private Date date;

    @JsonFormat(pattern = "HH:mm:ss")
    @Temporal(TemporalType.TIME)
    private Date time;

    public Projection() {
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

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
