package nl.fontys.cinelux.resources;

import nl.fontys.cinelux.models.User;
import nl.fontys.cinelux.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")   //http://localhost:3000

@RestController
@RequestMapping("/users")
public class UserResources {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping
    public User getUserById(@RequestParam long id) {
        if (userRepository.existsById(id)) {
            Optional<User> u = userRepository.findById(id);
            if (u.isPresent()) {
                return u.get();
            }
            return null;
        }
        return null;

    }

    @PostMapping("/add")
    public @ResponseBody
    String addNewUser(@RequestBody User user) {
        userRepository.save(user);
        return "Successfully added user " + user.getUsername();
    }

    @DeleteMapping("/delete")
    public @ResponseBody
    String deleteUser(@RequestParam long id) {

        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "Deleted user ";
        }
        return "User does not exist";
    }

    @PutMapping("/update")
    public @ResponseBody
    String updateUser(@RequestBody User user) {
        Optional<User> u = userRepository.findById(user.getId());
        if (u.isPresent()) {
            User updatedUser = u.get();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setEmail(user.getEmail());
            userRepository.save(updatedUser);
            return "Successfully updated person!";
        } else {
            return null;
        }
    }


}
