package nl.fontys.cinelux.resources;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import nl.fontys.cinelux.models.User;
import nl.fontys.cinelux.repository.FakeData;
import nl.fontys.cinelux.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResources {
    @Autowired
    private UserRepository userRepository;

    FakeData fakeData = new FakeData();

    @GetMapping
    public Iterable<User> getUsers() {
           return userRepository.findAll();
        }
}
