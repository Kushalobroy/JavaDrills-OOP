import java.util.*;
class Player3{
    private int id;
    private String name;
    private String country;
    private int matchesPlayed;
    private int runsScored;
    public Player3(int id, String name, String country, int matchesPlayed, int runsScored){
        this.id = id;
        this.name = name;
        this.country = country;
        this.matchesPlayed = matchesPlayed;
        this.runsScored = runsScored;
    }
    public int getId(){return id;}
    public String getName(){return name;}
    public String getCuntry(){return country;}
    public int getMachesPlayed(){return matchesPlayed;}
    public int getRunsScored(){return runsScored;}
}
public class Solution38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player3[] player3s = new Player3[5];
        for(int i=0;i<5;i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            int e = sc.nextInt(); sc.nextLine();
            player3s[i] = new Player3(a,b,c,d,e);
        }
        String c = sc.nextLine();
        int runs = sc.nextInt(); sc.nextLine();
        Player3[] p = findPlayerName(player3s, c, runs);
        if(p != null){
            for(Player3 a:p){
                System.out.println(a.getId()+":"+a.getName());
            }
        }
        else System.out.println("No player found");
        sc.close();
    }
    public static Player3[] findPlayerName(Player3[] p, String c, int runs){
        Player3[] fP = Arrays.stream(p).filter(a -> a.getCuntry().equalsIgnoreCase(c) && a.getRunsScored() > runs).toArray(Player3[]::new);
        if(fP.length == 0) return null;
        return fP;
    }
}
