package nl.fontys.cinelux.resources;

import nl.fontys.cinelux.models.Movie;
import nl.fontys.cinelux.models.Projection;
import nl.fontys.cinelux.repository.ProjectionRepository;
import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")  //http://localhost:3000
@RestController
@Component
@RequestMapping("/projections")
public class ProjectionResources {
    @Autowired
    private ProjectionRepository projectionRepository;

    @GetMapping("/all")
    public Iterable<Projection> getProjections() {
        return projectionRepository.findAll();
    }

    @GetMapping
    public Projection getProjectionById(@RequestParam long id) {
        if (projectionRepository.existsById(id)) {
            Optional<Projection> p = projectionRepository.findById(id);
            if (p.isPresent()) {
                return p.get();
            }
            return null;
        }
        return null;

    }

    @GetMapping("/findProjections")
    public List<Projection> getProjectionsByDateAndMovie(@RequestParam(value = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, Movie movie) {
        return projectionRepository.findByDateAndMovie(date, movie);

    }

    @GetMapping("/findByDate")
    public List<Projection> getProjectionsByDate(@RequestParam(value = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return projectionRepository.findByDate(date);

    }

    @PostMapping("/add")
    public @ResponseBody
    String addNewProjection(@RequestBody Projection projection) {
        projectionRepository.save(projection);
        return "Successfully added projection for " + projection.getMovie();
    }
}
