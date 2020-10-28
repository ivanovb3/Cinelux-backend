package nl.fontys.cinelux.resources;

import nl.fontys.cinelux.models.Projection;
import nl.fontys.cinelux.repository.ProjectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projections")
public class ProjectionResources {
    @Autowired
    private ProjectionRepository projectionRepository;

    @GetMapping
    public Iterable<Projection> getProjections(){
        return projectionRepository.findAll();
    }
}
