import java.util.*;
class Player{
    private int playerId;
    private String skill;
    private String level;
    private int points;
    public Player(int playerId, String skill, String level, int points){
        this.playerId = playerId;
        this.skill = skill;
        this.level = level;
        this.points = points;
    }
    public String getSkill(){return skill;}
    public int getPoints(){return points;}
    public int getPlayerId(){return playerId;}
    public String getLevel(){return level;}
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player[] players = new Player[4];
        for(int i=0;i<4;i++){
            int playerId = sc.nextInt();
            sc.nextLine();
            String skill = sc.nextLine();
            String level = sc.nextLine();
            int points = sc.nextInt();
            sc.nextLine();
            players[i] = new Player(playerId, skill, level, points);
        }
        String skill = sc.nextLine();
        String level = sc.nextLine();

        int point = findPointsForGivenSkill(players, skill);
        if(point>0) System.out.println(point);
        else System.out.println("The given Skill is not available");

        Player[] pl = getPlayerBasedOnLevel(players, skill, level);
        if(pl != null){
            for(Player p:pl) System.out.println(p.getPlayerId());
        } 
        else System.out.println("No player is availabel with specified level, skill and eligibility points");
    }
    public static Player[] getPlayerBasedOnLevel(Player[] players, String skill, String level){
        Player[] filteredPlayers = Arrays.stream(players).filter(p ->p.getLevel().equalsIgnoreCase(level) && p.getSkill().equalsIgnoreCase(skill) && p.getPoints()>=20).toArray(Player[]::new);
        if(filteredPlayers.length == 0 ) return null;
        return filteredPlayers;
    }
    public static int findPointsForGivenSkill(Player[] players, String skill){
        int sum=0;
        Player[] filteredPlayers = Arrays.stream(players).filter(p -> p.getSkill().equalsIgnoreCase(skill)).toArray(Player[]::new);
        if(filteredPlayers.length == 0) return 0;
        for(Player p:filteredPlayers){
            sum+=p.getPoints();
        }
        return sum;
    }
}
