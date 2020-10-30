package nl.fontys.cinelux.resources;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import nl.fontys.cinelux.models.User;
import nl.fontys.cinelux.repository.FakeData;
import nl.fontys.cinelux.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/users")
public class UserResources {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public Iterable<User> getUsers() {
           return userRepository.findAll();
    }

    /*@GetMapping("/login")
    public User loginUser(@RequestParam String email, @RequestParam String password){
        if(userRepository)
    } */

    //Always returns object even if null
    /*@GetMapping
    public Optional<User> getUserById(@RequestParam long id){
        return userRepository.findById(id);
    } */

    @GetMapping
    public User getUserById(@RequestParam long id){
        if(userRepository.existsById(id)){
        return userRepository.findById(id).get();
        }
        return null;

    }

    @PostMapping("/add")
    public @ResponseBody String addNewUser(@RequestBody User user){
        userRepository.save(user);
        return "Successfully added user " + user.getName();
    }
    @DeleteMapping("/delete")
    public @ResponseBody String deleteUser(@RequestParam long id){

        if(userRepository.existsById(id)){
        userRepository.deleteById(id);
        return "Deleted user ";
        }
        return "User does not exist";
    }
    @PutMapping("/update")
    public @ResponseBody String updateUser(@RequestBody User user){
        User updatedUser = userRepository.findById(user.getId()).get();
        updatedUser.setName(user.getName());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setEmail(user.getEmail());
        userRepository.save(updatedUser);
        return "Successfully updated person!";
    }

    @GetMapping("/login")
    public User logInUser(@RequestParam String email, String password){
        User user = userRepository.findByEmailAndPassword(email, password);
        return user;
    }



}
