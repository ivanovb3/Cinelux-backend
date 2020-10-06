package nl.fontys.cinelux.repository;

import nl.fontys.cinelux.models.Ticket;
import nl.fontys.cinelux.models.User;

import java.util.ArrayList;
import java.util.List;

public class FakeData {
    List<User> usersList = new ArrayList<>();
    List<Ticket> ticketsList = new ArrayList<>();

    public FakeData() {
        // work this out better, add few more countries and students
       /* User George = new User("george.todorov@gmail.com", "George Todorov");
        User Teodor = new User("teodor.georgiev@gmail.com", "Teodor Georgiev");
        User Asen = new User("asen.ivanov@gmail.com", "Asen Ivanov");
        usersList.add(George);
        usersList.add(Teodor);
        usersList.add(Asen);

        ticketsList.add(new Ticket(George, "1a"));
        ticketsList.add(new Ticket(Teodor, "1b"));
        ticketsList.add(new Ticket(Asen, "1c")); */

    }

    public List<User> getUsers() {return this.usersList; }
}
