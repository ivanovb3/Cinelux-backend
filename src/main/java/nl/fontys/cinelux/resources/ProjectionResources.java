package nl.fontys.cinelux.resources;

import nl.fontys.cinelux.models.Movie;
import nl.fontys.cinelux.models.Projection;
import nl.fontys.cinelux.repository.ProjectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin("*")  //http://localhost:3000
@RestController
@RequestMapping("/projections")
public class ProjectionResources {
    @Autowired
    private ProjectionRepository projectionRepository;

    @GetMapping("/all")
    public Iterable<Projection> getProjections(){
        return projectionRepository.findAll();
    }

    @GetMapping
    public Projection getProjectionById(@RequestParam long id){
        if(projectionRepository.existsById(id)){
            return projectionRepository.findById(id).get();
        }
        return null;

    }
    @GetMapping("/findProjections")
    public List<Projection> getProjectionsByDateAndMovie(@RequestParam(value = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, Movie movie){
        //for(int i = 0; i < projectionRepository.findByDate(date))
        return projectionRepository.findByDateAndMovie(date, movie);
        //return null;

    }
    @GetMapping("/findByDate")
    public List<Projection> getProjectionsByDate(@RequestParam(value = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        //for(int i = 0; i < projectionRepository.findByDate(date))
        return projectionRepository.findByDate(date);
        //return null;

    }
    @PostMapping("/add")
    public @ResponseBody String addNewProjection(@RequestBody Projection projection){
        projectionRepository.save(projection);
        return "Successfully added projection for " + projection.getMovie();
    }
}
