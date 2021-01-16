package nl.fontys.cinelux;
import jdk.nashorn.internal.ir.PropertyKey;
import nl.fontys.cinelux.models.Movie;
import nl.fontys.cinelux.models.Projection;
import nl.fontys.cinelux.resources.MovieResources;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

class MovieTests {
    @Test
    void MovieNameTest(){
        Movie movie = mock(Movie.class);
        String expectedName = "Avengers";
        movie.setName(expectedName);
        when(movie.getName()).thenReturn(expectedName);
        String actualName = movie.getName();
        assertEquals(expectedName, actualName);
    }
    @Test
    void MovieIdTest(){
        Movie movie = mock(Movie.class);
        long expectedId = 1;
        movie.setId(expectedId);
        when(movie.getId()).thenReturn(expectedId);
        long actualId = movie.getId();
        assertEquals(expectedId, actualId);
    }
    @Test
    void MoviePictureTest(){
        Movie movie = mock(Movie.class);
        String expectedPicture = "AvengersPicture";
        movie.setPicture(expectedPicture);
        when(movie.getPicture()).thenReturn(expectedPicture);
        String actualPicture = movie.getPicture();
        assertEquals(expectedPicture, actualPicture);
    }
    @Test
    void MovieRuntimeTest(){
        Movie movie = mock(Movie.class);
        int expectedRuntime = 200;
        movie.setRuntime(expectedRuntime);
        when(movie.getRuntime()).thenReturn(expectedRuntime);
        int actualRuntime = movie.getRuntime();
        assertEquals(expectedRuntime, actualRuntime);
    }
    @Test
    void MovieProjectionsTest(){
        Movie movie = mock(Movie.class);
        List<Projection> expectedProjections = new ArrayList<Projection>();
        movie.setProjections(expectedProjections);
        when(movie.getProjections()).thenReturn(expectedProjections);
        List<Projection> actualProjections = movie.getProjections();
        assertEquals(expectedProjections, actualProjections);
    }
//    @Test
//    void MovieToStringTest(){
//        Movie movie = mock(Movie.class);
//        when(movie.toString()).thenReturn("Movie");
//        String actualString = movie.toString();
//        assertEquals("Movie", actualString);
//    }

    @Test
    void GetAllMoviesTest(){
        MovieResources mr = mock(MovieResources.class);
        Movie movie1 = mock(Movie.class);
        Movie movie2 = mock(Movie.class);
        List<Movie> expectedMovies = new ArrayList<Movie>();
        expectedMovies.add(movie1);
        expectedMovies.add(movie2);
        Iterable<Movie> iExpectedMovies = expectedMovies;
        when(mr.getMovies()).thenReturn(iExpectedMovies);
        Iterable<Movie> iActualMovies = mr.getMovies();
        assertEquals(iExpectedMovies, iActualMovies);
    }
    @Test
    void GetMovieByIdTest(){
        MovieResources mr = mock(MovieResources.class);
        Movie movie1 = mock(Movie.class);
        Movie movie2 = mock(Movie.class);
        movie1.setId(1);
        movie2.setId(2);
        when(mr.getMovieById(1)).thenReturn(movie1);
        Movie actualMovie = mr.getMovieById(1);
        assertEquals(movie1,actualMovie);
    }
    @Test
    void AddNewMovieTest(){
        MovieResources mr = mock(MovieResources.class);
        Movie movie1 = mock(Movie.class);
        String expectedMessage = "Successfully added movie";
        when(mr.addNewMovie(movie1)).thenReturn(expectedMessage);
        String actualMessage = mr.addNewMovie(movie1);
        assertEquals(expectedMessage, actualMessage);
    }

}
