import java.util.*;
class Cinema{
    private int movieId;
    private String director;
    private int rating;
    private int budget;
    public Cinema(int movieId, String director, int rating, int budget){
        this.movieId = movieId;
        this.director = director;
        this.rating = rating;
        this.budget = budget;
    }
    public int getId(){return movieId;}
    public String getDirector(){return director;}
    public int getRating(){return rating;}
    public int getBudget(){return budget;}
}
public class Solution29 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Cinema[] cinemas = new Cinema[4];
        for(int i=0;i<4;i++){
            int movieId = sc.nextInt();
            sc.nextLine();
            String director = sc.nextLine();
            int rating = sc.nextInt(); sc.nextLine();
            int budget = sc.nextInt(); sc.nextLine();
            cinemas[i] = new Cinema(movieId, director, rating, budget);
        }
        String dr = sc.nextLine();
        int rat = sc.nextInt();
        sc.nextLine();
        int bud = sc.nextInt();
        sc.nextLine();
        int avg = findAvgBudgetByDirector(cinemas, dr);
        if(avg>0) System.out.println(avg);
        else System.out.println("Sorry - The given director has not yet directed any movie");

        Cinema[] cinemas2 = getMovieByRatingBudget(cinemas, rat, bud);
        if(cinemas2 != null){
            for(Cinema c: cinemas2){
                System.out.println(c.getId());
            }
        }
        else System.out.println("Sorry - No movie is available with the specified rating and budget requiremenet");
        sc.close();
    }
    public static Cinema[] getMovieByRatingBudget(Cinema[] cinemas, int rating, int budget){
        Cinema[] fC = Arrays.stream(cinemas).filter(c -> c.getRating() == rating && c.getBudget() == budget && (c.getBudget()%c.getRating()==0)).toArray(Cinema[]::new);
        if(fC.length == 0 ) return null;
        return fC;
    }
    public static int findAvgBudgetByDirector(Cinema[] cinemas, String director){
        int sum = 0;
        Cinema[] fC = Arrays.stream(cinemas).filter(c -> c.getDirector().equalsIgnoreCase(director)).toArray(Cinema[]::new);
        if(fC.length==0) return 0;
        for(Cinema c:fC){
            sum += c.getBudget();
        }
        return sum/fC.length;
    }
}
