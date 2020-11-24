package nl.fontys.cinelux.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "MOVIES")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private long id;
    @Column(name = "movie_name")    //, nullable = false
    private String name;
    @Column(name = "movie_picture")    //
    private String picture;
    @Column(name = "movie_runtime")    //
    private int runtime;

    @OneToMany(mappedBy = "movie")  // fetch = FetchType.LAZY,  cascade = CascadeType.ALL
    private List<Projection> projections;

    public Movie() {
    }

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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Projection> getProjections() {
        return projections;
    }

    public void setProjections(List<Projection> projections) {
        this.projections = projections;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", projections=" + projections +
                '}';
    }
}
