package nl.fontys.cinelux.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "MOVIES")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private long id;
    @Column(name = "movie_name", nullable = false)
    private String name;
    @Column(name = "projection_date", nullable = false)
    private Date date;
    @Column(name = "movie_picture", nullable = false)
    private String picture;
    @OneToMany(mappedBy = "movie")
    private List<Ticket> tickets;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Movie() {    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", picture='" + picture + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}
