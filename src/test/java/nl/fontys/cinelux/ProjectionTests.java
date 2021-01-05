package nl.fontys.cinelux;

import nl.fontys.cinelux.models.Movie;
import nl.fontys.cinelux.models.Projection;
import nl.fontys.cinelux.models.Ticket;
import nl.fontys.cinelux.resources.ProjectionResources;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

class ProjectionTests {
    @Test
    void ProjectionIdTest(){
        Projection projection = mock(Projection.class);
        long expectedId = 1;
        projection.setId(expectedId);
        when(projection.getId()).thenReturn(expectedId);
        long actualId = projection.getId();
        assertEquals(expectedId, actualId);
    }
    @Test
    void ProjectionMovieTest(){
        Projection projection = mock(Projection.class);
        Movie movie = mock(Movie.class);
        projection.setMovie(movie);
        when(projection.getMovie()).thenReturn(movie);
        Movie actualMovie = projection.getMovie();
        assertEquals(movie, actualMovie);
    }
    @Test
    void ProjectionDateTest(){
        Projection projection = mock(Projection.class);
        Date pDate = mock(Date.class);
        projection.setDate(pDate);
        when(projection.getDate()).thenReturn(pDate);
        Date actualDate = projection.getDate();
        assertEquals(pDate, actualDate);
    }
    @Test
    void ProjectionTimeTest(){
        Projection projection = mock(Projection.class);
        Date ptDate = mock(Date.class);
        projection.setTime(ptDate);
        when(projection.getTime()).thenReturn(ptDate);
        Date actualTime = projection.getTime();
        assertEquals(ptDate, actualTime);
    }
    @Test
    void ProjectionTicketsTest(){
        Projection projection = mock(Projection.class);
        Ticket ticket1 = mock(Ticket.class);
        Ticket ticket2 = mock(Ticket.class);
        List<Ticket> tickets = new ArrayList<Ticket>();
        tickets.add(ticket1);
        tickets.add(ticket2);
        projection.setTickets(tickets);
        when(projection.getTickets()).thenReturn(tickets);
        List<Ticket> actualTickets = projection.getTickets();
        assertEquals(tickets, actualTickets);
    }
    @Test
    void ProjectionToStringTest(){
        Projection projection = mock(Projection.class);
        when(projection.toString()).thenReturn("Projection");
        String actualString = projection.toString();
        assertEquals("Projection", actualString);
    }
    @Test
    void GetProjectionsTest(){
        ProjectionResources pr = mock(ProjectionResources.class);
        Projection p1 = mock(Projection.class);
        Projection p2 = mock(Projection.class);
        List<Projection> projections = new ArrayList<Projection>();
        projections.add(p1);
        projections.add(p2);
        Iterable<Projection> expectedProjections = projections;
        when(pr.getProjections()).thenReturn(expectedProjections);
        Iterable<Projection> actualProjecitons = pr.getProjections();
        assertEquals(actualProjecitons, expectedProjections);
    }
    @Test
    void GetProjectionByIdTest(){
        ProjectionResources pr = mock(ProjectionResources.class);
        Projection p1 = mock(Projection.class);
        p1.setId(11);
        when(pr.getProjectionById(11)).thenReturn(p1);
        Projection actualProjection = pr.getProjectionById(11);
        assertEquals(p1, actualProjection);
    }
    @Test
    void GetProjectionsByDateTest(){
        ProjectionResources pr = mock(ProjectionResources.class);
        Projection p1 = mock(Projection.class);
        List<Projection> projections = new ArrayList<Projection>();
        projections.add(p1);
        Date date = mock(java.sql.Date.class);
        when(pr.getProjectionsByDate(date)).thenReturn(projections);
        List<Projection> actualProjections = pr.getProjectionsByDate(date);
        assertEquals(projections, actualProjections);
    }
    @Test
    void GetProjectionsByDateAndMovieTest(){
        ProjectionResources pr = mock(ProjectionResources.class);
        Projection p1 = mock(Projection.class);
        Movie m = mock(Movie.class);
        List<Projection> projections = new ArrayList<Projection>();
        projections.add(p1);
        Date date = mock(Date.class);
        when(pr.getProjectionsByDateAndMovie(date, m)).thenReturn(projections);
        List<Projection> actualProjections = pr.getProjectionsByDateAndMovie(date, m);
        assertEquals(projections, actualProjections);
    }
    @Test
    void AddNewProjection(){
        ProjectionResources pr = mock(ProjectionResources.class);
        Projection p1 = mock(Projection.class);
        String message = "New Projection added";
        when(pr.addNewProjection(p1)).thenReturn(message);
        String actualMessage = pr.addNewProjection(p1);
        assertEquals(message, actualMessage);
    }
}
