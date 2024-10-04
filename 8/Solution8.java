import java.util.*;
class Movie{
    private String movieName;
    private String company;
    private String genre;
    private int budget;

    public Movie(String movieName, String comapany, String genre, int budget){
        this.movieName = movieName;
        this.company = company;
        this.genre = genre;
        this.budget = budget;
    }
    public int getBudget(){return budget;}
    public String getGenre(){return genre;}
}
public class Solution8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Movie[] movies = new Movie[4];
        for(int i=0;i<4;i++){
            String movieName = sc.nextLine();
            String company = sc.nextLine();
            String genre = sc.nextLine();
            int budget = sc.nextInt();
            sc.nextLine();
            movies[i] = new Movie(movieName, company, genre, budget);
        }
        String genreInput = sc.nextLine();
        Movie[] movies2 = getMovieByGenre(movies, genreInput);
        if(movies2 != null){
            for(Movie m:movies2){
                if(m.getBudget()>80000000) System.out.println("High Budget Movie");
                else System.out.println("Low Budget Movie");
            }
        }
    }
    public static Movie[] getMovieByGenre(Movie[] movies, String genre){
        Movie[] filteredMovies = Arrays.stream(movies).filter(m -> m.getGenre().equalsIgnoreCase(genre)).toArray(Movie[]::new);
        return filteredMovies;
    }
}
