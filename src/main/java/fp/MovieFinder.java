package fp;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieFinder {


    public List<Movie> findByTitle(List<Movie> allMovies, String searchTitle) {

        Function<String, Function<String, Boolean>> isInfixOf = title -> whole -> whole.contains(title);

        Function<Movie, String> getTitle = movie -> movie.getTitle();

        Function<String, Function<Movie, Boolean>> matches = title -> isInfixOf.apply(title).compose(getTitle);

        List<Movie> result = allMovies.stream().filter(movie -> matches.apply(searchTitle).apply(movie)).collect(Collectors.toList());

        return result;
    }



    public List<Movie> findByTitle3(List<Movie> allMovies, String searchTitle) {

        Function<Predicate<Movie>, Function<List<Movie>, List<Movie>>> filter = moviePredicate -> movies -> movies.stream().filter(moviePredicate).collect(Collectors.toList());

        Function<String, Function<String, Boolean>> isInfixOf = title -> whole -> whole.contains(title);

        Function<Movie, String> getTitle = movie -> movie.getTitle();

        Function<String, Predicate<Movie>> matches = title -> movie -> isInfixOf.apply(title).compose(getTitle).apply(movie);

        Function<String, Function<List<Movie>, List<Movie>>> findBytitle = title  -> movies -> filter.compose(matches).apply(title).apply(movies);

        List<Movie> result = findBytitle.apply(searchTitle).apply(allMovies);

        return result;
    }

}
