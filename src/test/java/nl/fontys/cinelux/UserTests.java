package nl.fontys.cinelux;
import nl.fontys.cinelux.models.User;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class UserTests {
    @Test
    public void userNameTest(){
        String expectedName = "Rostislav";
        User user = new User(expectedName, "password", "rostislav@gmail.com");
        String actualName = user.getUsername();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void mockitoUserTest(){
        String expectedName = "Rostislav";

        User user = mock(User.class);

        when(user.getUsername()).thenReturn(expectedName);

        String actualName = user.getUsername();

        assertEquals(expectedName, actualName);

    }
}
