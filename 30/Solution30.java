import java.util.*;
class Player2{
    private int id;
    private String name;
    private int iccRank;
    private int machesPlayed;
    private int runsScored;
    public Player2(int id, String name, int iccRank, int machesPlayed, int runsScored){
        this.id = id;
        this.name = name;
        this.iccRank = iccRank;
        this.machesPlayed = machesPlayed;
        this.runsScored = runsScored;
    }
    public int getScoredRun(){return runsScored;}
    public int getMachesPlayed(){return machesPlayed;}
}
public class Solution30 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Player2[] player2s = new Player2[4];
        for(int i=0;i<4;i++){
            int id = sc.nextInt(); sc.nextLine();
            String name = sc.nextLine();
            int iccRank = sc.nextInt(); sc.nextLine();
            int matchesPlayed = sc.nextInt(); sc.nextLine();
            int runsScored = sc.nextInt(); sc.nextLine();
            player2s[i] = new Player2(id, name, iccRank, matchesPlayed, runsScored);
        }
        int target = sc.nextInt(); sc.nextLine();
        double[] ans = findAverageOfRuns(player2s, target);
        if(ans != null){
            for (int i = 0; i < ans.length; i++) {
                if(ans[i]>=80 && ans[i]<=100)
                {
                    System.out.println("Grade A");
                }
                else if(ans[i]>=50 && ans[i]<=79)
                {
                    System.out.println("Grade B");
                }
                else
                {
                    System.out.println("Grade C");
                }
            }
        }
        sc.close();
    }
    public static double[] findAverageOfRuns(Player2[] player2s, int target){
        double arr[] = new double[0];
        for(int i=0;i<player2s.length;i++){
            if(player2s[i].getMachesPlayed() >= target){
                arr = Arrays.copyOf(arr, arr.length+1);
                arr[arr.length-1] = (player2s[i].getScoredRun()/player2s[i].getMachesPlayed()); 
            }
        }
        if(arr.length > 0) return arr;
        else return null;
    }
}
