package nl.fontys.cinelux.resources;

import nl.fontys.cinelux.models.Movie;
import nl.fontys.cinelux.models.Projection;
import nl.fontys.cinelux.repository.ProjectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@CrossOrigin("*")  //http://localhost:3000
@RestController
@Component
@RequestMapping("/projections")
public class ProjectionResources {
    @Autowired
    private ProjectionRepository projectionRepository;

    /*@PostConstruct
    void DeleteOldProjections(){
        List<Projection> projections = projectionRepository.findAll();
        LocalDate date = LocalDate.now(); // Gets the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date current = Date.valueOf(date.format(formatter));
        for(int i = 0; i< projections.size(); i++){
            if(projections.get(i).getDate().before(current)){
                projectionRepository.deleteById(projections.get(i).getId());
            }
        }

    } */
    @GetMapping("/all")
    public Iterable<Projection> getProjections() {
        return projectionRepository.findAll();
    }

    @GetMapping
    public Projection getProjectionById(@RequestParam long id) {
        if (projectionRepository.existsById(id)) {
            return projectionRepository.findById(id).get();
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
