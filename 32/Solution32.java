import java.util.*;
class Team{
    private int tId;
    private String tName;
    private String tCountry;
    private int tRun;
    public Team(int tId, String tName, String tCountry, int tRun){
        this.tId = tId;
        this.tName = tName;
        this.tCountry = tCountry;
        this.tRun = tRun;
    }
    public int getRun(){return tRun;}
    public String getCountry(){return tCountry;}
    public int getId(){return tId;}
    public String getName(){return tName;}
}
public class Solution32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Team[] teams = new Team[3];
        for(int i=0;i<3;i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            teams[i] = new Team(a,b,c,d);
        }
        int run = sc.nextInt(); sc.nextLine();
        String country = sc.nextLine();
        Team[] teams2 = findPlayer(teams,run,country);
        if(teams2 != null){
            for(Team t:teams2){
                System.out.println(t.getId());
                System.out.println(t.getName());
                System.out.println(t.getCountry());
                System.out.println(t.getRun());
            }
        }
        else System.out.println("No team is found from the given country and run");
        sc.close();
    }
    public static Team[] findPlayer(Team[] teams, int run, String country){
        Team[] fT = Arrays.stream(teams).filter(t -> t.getCountry().equalsIgnoreCase(country) && t.getRun() > run).toArray(Team[]::new);
        if(fT.length == 0) return null;
        return fT;
    }

}
