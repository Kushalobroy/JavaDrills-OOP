import java.util.*;
class Music{
    private int playListNo;
    private String type;
    private int count;
    private double duration;
    public Music(int playListNo, String type, int count, double duration) {
        this.playListNo = playListNo;
        this.type = type;
        this.count = count;
        this.duration = duration;
    }
    public int getPlayListNo(){return playListNo;}
    public String getType(){return type;}
    public int getCount(){return count;}
    public double getDuration(){return duration;}
}
public class Solution35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Music[] musics = new Music[4];
        for(int i=0;i<4;i++){
            int playListNo = sc.nextInt(); sc.nextLine();
            String type = sc.nextLine();
            int count = sc.nextInt(); sc.nextLine();
            double duration = sc.nextDouble(); sc.nextLine();
            musics[i] = new Music(playListNo, type, count, duration);
        }
        int countInput = sc.nextInt(); sc.nextLine();
        double durationInput = sc.nextDouble(); sc.nextLine();
        int avg = findAvgOfCount(musics, countInput);
        if(avg>0) System.out.println(avg);
        else System.out.println("No playlist found");

        Music[] musics2 = sortTypeByDuration(musics, durationInput);
        if(musics2 != null){
            for(Music s:musics2){
                System.out.println(s.getType());
            }
        }
        else System.out.println("No playlist found with mentioned attribute");
        sc.close();
    }
    public static int findAvgOfCount(Music[] musics, int count){
        int sum = 0;
        Music[] fM = Arrays.stream(musics).filter(m -> m.getCount()>count).toArray(Music[]::new);
        if(fM.length == 0) return 0;
        for(Music m:fM) sum += m.getCount();
        return sum/fM.length;
    }
    public static Music[] sortTypeByDuration(Music[] musics, double duration){
        Music[] fM = Arrays.stream(musics).filter(m -> m.getDuration()>duration).toArray(Music[]::new);
        if(fM.length == 0) return null;
        Arrays.sort(fM, (m1, m2)-> Double.compare(m1.getDuration(), m2.getDuration()));
        return fM;
    }
}
