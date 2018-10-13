import java.io.IOException;

public class FilmwebController {
    private static final int ADD_MOVIE = 1;
    private static final int DELETE_MOVIE = 2;
    private static final int FIND_MOVIE = 3;
    private static final int EXIT = 4;
    private UIService uis = new UIService();
    private MovieDatabase md = new MovieDatabase();
    private FileService fs = new FileService();

    void mainLoop() {
        int option;
        do {
            showOptions();
            option = readOption();
            executeOption(option);
        } while (option != EXIT);
    }
        void showOptions () {
            System.out.println(ADD_MOVIE + " - Dodanie filmu");
            System.out.println(DELETE_MOVIE + " - Usuwanie filmu ");
            System.out.println(FIND_MOVIE + " - Wyszukaj film");
            System.out.println(EXIT + " - Koniec programu");
        }
        int readOption () {

            int optionNumber = uis.readOption();
            return optionNumber;
        }
        void executeOption ( int optionNumber){
            switch (optionNumber) {
                case ADD_MOVIE:
                    addMovie();
                    break;
                case DELETE_MOVIE:
                    deleteMovie();
                    break;
                case FIND_MOVIE:
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Nieznana opcja");
            }
        }

    private void exit() {
        try{
            fs.save(md);
            System.out.println("Dane zapisano do pliku");
        }catch(IOException ex){
            System.out.println("Nie udało się zapisać do pliku");
        }
        }

    private void addMovie(){
            Movie movie = uis.readMovie();
        try {
            md.add(movie);
        } catch (DuplicateMovieException e) {
            System.out.println("Próbujesz dodać film o takim samym ID");
        }
    }
        private void deleteMovie(){
        int movieId=uis.readMovieId();
        md.removeById(movieId);
        }
    }