package nl.fontys.cinelux.resources;

import nl.fontys.cinelux.models.Movie;
import nl.fontys.cinelux.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")    //http://localhost:3000
@RestController
@RequestMapping("/movies")
public class MovieResources {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/all")
    public Iterable<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @GetMapping
    public Movie getMovieById(@RequestParam long id) {
        if (movieRepository.existsById(id)) {
            Optional<Movie> m = movieRepository.findById(id);
            if (m.isPresent()) {
                return m.get();
            }
            return null;
        }
        return null;

    }

    @PostMapping("/add")
    public @ResponseBody
    String addNewMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
        return "Successfully added movie " + movie.getName();
    }

    @DeleteMapping("/delete")
    public @ResponseBody
    String deleteMovie(@RequestParam long id) {
        movieRepository.deleteById(id);
        return "Successfully deleted movie";
    }
}
