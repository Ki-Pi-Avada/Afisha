import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    @Test

    public void shouldAddMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");

        String[] expected = {"Фильм 1", "Фильм 2"};
        Assertions.assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldFindAllMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");

        String[] expected = {"Фильм 1", "Фильм 2", "Фильм 3"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldFindLastMovieWithDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");
        manager.addMovie("Фильм 4");
        manager.addMovie("Фильм 5");
        manager.addMovie("Фильм 6");

        String[] expected = {"Фильм 6", "Фильм 5", "Фильм 4", "Фильм 3", "Фильм 2"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastMovieWithCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");
        manager.addMovie("Фильм 4");

        String[] expected = {"Фильм 4", "Фильм 3", "Фильм 2"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastMovieWhenLessThanLimit() {
        MovieManager manager = new MovieManager(5);
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");

        String[] expected = {"Фильм 2", "Фильм 1"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastMovieWhenEmpty() {
        MovieManager manager = new MovieManager();
        String[] expected = {};
        assertArrayEquals(expected, manager.findLast());
    }
}
