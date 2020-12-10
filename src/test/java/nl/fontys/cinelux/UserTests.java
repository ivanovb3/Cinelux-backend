package nl.fontys.cinelux;
import nl.fontys.cinelux.models.ERole;
import nl.fontys.cinelux.models.Role;
import nl.fontys.cinelux.models.User;

import nl.fontys.cinelux.resources.UserResources;
import org.junit.jupiter.api.Test;


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
    void mockitoUserTest(){
        String expectedName = "Rostislav";

        User user = mock(User.class);

        user.setUsername(expectedName);

        when(user.getUsername()).thenReturn(expectedName);

        String actualName = user.getUsername();

        assertEquals(expectedName, actualName);
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

    @Test
    void logInUserTest(){
        User expectedUser = new User("Rostislav", "123456", "rosti.rosenov@gmail.com");
        UserResources userResources = mock(UserResources.class);

        when(userResources.logInUser(expectedUser.getEmail(), expectedUser.getPassword())).thenReturn(expectedUser);
        User actualUser = userResources.logInUser("rosti.rosenov@gmail.com", "123456");
        assertEquals(expectedUser, actualUser);
    }

    @Test
    void logInUserTest_withWrongCredentials(){
        User expectedUser = new User("Rostislav", "123456", "rosti.rosenov@gmail.com");
        UserResources userResources = mock(UserResources.class);

        when(userResources.logInUser(expectedUser.getEmail(), expectedUser.getPassword())).thenReturn(expectedUser);
        User actualUser = userResources.logInUser("rosti.rosenoov@gmail.com", "123456");
        assertNotEquals(expectedUser, actualUser);
    }
    /*@Test
    public void userRolesTest(){

       // Role expectedRole = new Role(ERole.ROLE_ADMIN);
        Set<Role> expectedRole = new Set<Role>();
        User user = mock(User.class);

        when(user.getRoles()).thenReturn(expectedRole);

        Role actualRole = (Role)user.getRoles();


        assertEquals(expectedRole, actualRole);



    } */
}
