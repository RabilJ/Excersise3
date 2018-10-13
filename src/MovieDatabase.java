import java.util.ArrayList;
import java.util.List;

public class MovieDatabase {
    private List<Movie> movies = new ArrayList<>();

    public List<Movie> getMovies() {
        return movies;
    }

    public void add(Movie movie)throws DuplicateMovieException {
        Movie foundMovie = findById(movie.getId());
        if(foundMovie!=null)
            throw new DuplicateMovieException();
        movies.add(movie);
    }

    public void removeById(int movieId) {
        Movie foundMovie = findById(movieId);
        if (foundMovie != null)
            movies.remove(foundMovie);
    }
        Movie findById ( int movieId){
            for (Movie movie : movies) {
                if (movie.getId() == movieId) {
                    return movie;
                }
            }
            return null;
        }
    }
