import java.util.Scanner;

public class UIService {
    private static Scanner sc = new Scanner(System.in);

    Movie readMovie(){
        System.out.println("Podaj unikalne id");
        int id = readInt();
        System.out.println("Podaj tytuł: ");
        String title = sc.nextLine();
        System.out.println("Podaj rok nakręcenia: ");
        int year = readInt();
        System.out.println("Podaj gatunek filmowy: ");
        String genre = sc.nextLine();
        System.out.println("Podaj reżysera: ");
        String director = sc.nextLine();
        Movie movie = new Movie(id, title,year,genre,director);
        return movie;
        }
        int readOption(){
            System.out.println("Podaj numer opcji");
            return readInt();
        }
        private int readInt(){
        int number = sc.nextInt();
        sc.nextLine();
        return number;
        }
        int readMovieId(){
            System.out.println("Podaj id filmu");
            return readInt();
        }
    }

