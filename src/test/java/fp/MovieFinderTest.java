package fp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieFinderTest {

    List<Movie> movies ;
    @Before
    public void setup(){

        movies = new ArrayList<>();
        Movie movie = new Movie();
        movie.setTitle("The Matrix");
        movies.add(movie);

        movie = new Movie();
        movie.setTitle("A beautiful mind");
        movies.add(movie);

        movie = new Movie();
        movie.setTitle("Intouchable");
        movies.add(movie);

        movie = new Movie();
        movie.setTitle("Forest Gump");
        movies.add(movie);
    }
    @Test
    public void findByTitle() {
        MovieFinder movieFinder = new MovieFinder();

        List<Movie> searchResult = movieFinder.findByTitle(movies, "XXXXXXX");
        Assert.assertTrue("Should be empty", searchResult.isEmpty());

        searchResult = movieFinder.findByTitle(movies, "mind");
        Assert.assertEquals("A beautiful mind", searchResult.get(0).getTitle());


        searchResult = movieFinder.findByTitle(movies, "a");
        Assert.assertEquals(3, searchResult.size());
        Assert.assertEquals("The Matrix", searchResult.get(0).getTitle());
        Assert.assertEquals("A beautiful mind", searchResult.get(1).getTitle());
    }



    @Test
    public void findByTitle2() {
        MovieFinder movieFinder = new MovieFinder();

        List<Movie> searchResult = movieFinder.findByTitle2(movies, "XXXXXXX");
        Assert.assertTrue("Should be empty", searchResult.isEmpty());

        searchResult = movieFinder.findByTitle2(movies, "mind");
        Assert.assertEquals("A beautiful mind", searchResult.get(0).getTitle());


        searchResult = movieFinder.findByTitle2(movies, "a");
        Assert.assertEquals(3, searchResult.size());
        Assert.assertEquals("The Matrix", searchResult.get(0).getTitle());
        Assert.assertEquals("A beautiful mind", searchResult.get(1).getTitle());
    }



    @Test
    public void findByTitle3() {
        MovieFinder movieFinder = new MovieFinder();

        List<Movie> searchResult = movieFinder.findByTitle3(movies, "XXXXXXX");
        Assert.assertTrue("Should be empty", searchResult.isEmpty());

        searchResult = movieFinder.findByTitle3(movies, "mind");
        Assert.assertEquals("A beautiful mind", searchResult.get(0).getTitle());


        searchResult = movieFinder.findByTitle3(movies, "a");
        Assert.assertEquals(3, searchResult.size());
        Assert.assertEquals("The Matrix", searchResult.get(0).getTitle());
        Assert.assertEquals("A beautiful mind", searchResult.get(1).getTitle());
    }
}