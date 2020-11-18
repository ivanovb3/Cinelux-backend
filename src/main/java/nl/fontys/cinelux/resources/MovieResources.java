package nl.fontys.cinelux.resources;

import nl.fontys.cinelux.models.Movie;
import nl.fontys.cinelux.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")    //http://localhost:3000
@RestController
@RequestMapping("/movies")
public class MovieResources {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/all")
    private Iterable<Movie> getMovies(){
        return movieRepository.findAll();
    }
    @GetMapping
    public Movie getMovieById(@RequestParam long id){
        if(movieRepository.existsById(id)){
            return movieRepository.findById(id).get();
        }
        return null;

    }
    @PostMapping("/add")
    public @ResponseBody String addNewMovie(@RequestBody Movie movie){
        movieRepository.save(movie);
        return "Successfully added movie " + movie.getName();
    }
}
