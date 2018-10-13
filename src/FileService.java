import java.io.*;
import java.util.List;

public class FileService {
    private static final String FILE_NAME = "movies.csv";

    void save(MovieDatabase database)throws IOException {
        BufferedWriter bfw = new BufferedWriter(new FileWriter("movies.csv"));
        List<Movie>movies = database.getMovies();
        for (Movie movie : movies) {
            String csv = movie.toCsv();
            bfw.write(csv);
            bfw.newLine();
        }
        bfw.close();
    }
}
