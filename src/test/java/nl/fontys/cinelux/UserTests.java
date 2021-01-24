package nl.fontys.cinelux;
import nl.fontys.cinelux.models.ERole;
import nl.fontys.cinelux.models.Role;
import nl.fontys.cinelux.models.Ticket;
import nl.fontys.cinelux.models.User;

import nl.fontys.cinelux.resources.UserResources;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;


class UserTests {
    @Test
    void userNameTest(){
        String expectedName = "Rostislav";
        User user = new User(expectedName, "password", "rostislav@gmail.com");
        String actualName = user.getUsername();
        assertEquals(expectedName, actualName);
    }

    @Test
    void UserNameTest(){
        String expectedName = "Rostislav";

        User user = mock(User.class);

        user.setUsername(expectedName);

        when(user.getUsername()).thenReturn(expectedName);

        String actualName = user.getUsername();

        assertEquals(expectedName, actualName);
    }
    @Test
    void UserEmailTest(){
        String expectedEmail = "test@gmail.com";
        User user = mock(User.class);
        user.setEmail(expectedEmail);
        when(user.getEmail()).thenReturn(expectedEmail);
        String actualEmail = user.getEmail();
        assertEquals(expectedEmail,actualEmail);
    }
    @Test
    void UserPasswordTest(){
        String expectedPassword = "123456";
        User user = mock(User.class);
        user.setPassword(expectedPassword);
        when(user.getPassword()).thenReturn(expectedPassword);
        String actualPassword = user.getPassword();
        assertEquals(expectedPassword,actualPassword);
    }
    @Test
    void UserIdTest(){
        long expectedId = 1;
        User user = mock(User.class);
        user.setId(expectedId);
        when(user.getId()).thenReturn(expectedId);
        long  actualId = user.getId();
        assertEquals(expectedId,actualId);
    }
    @Test
    void userTicketTest(){
        User user = mock(User.class);
        List<Ticket> tickets = new ArrayList<>();
        Ticket t1 = mock(Ticket.class);
        Ticket t2 = mock(Ticket.class);
        tickets.add(t1);
        tickets.add(t2);
        user.setTickets(tickets);
        when(user.getTickets()).thenReturn(tickets);
        List<Ticket> actualTickets = user.getTickets();
        assertEquals(tickets, actualTickets);
    }

    @Test
    void registerUserTest(){
        User expectedUser = new User("Rostislav", "123456", "rosti.rosenov@gmail.com");
        UserResources userResources = mock(UserResources.class);
        //User user = mock(User.class);

        when(userResources.addNewUser(expectedUser)).thenReturn("Successfully added user " + expectedUser.getUsername());

        String success = userResources.addNewUser(expectedUser);
        assertEquals(success,"Successfully added user Rostislav");
    }


}
