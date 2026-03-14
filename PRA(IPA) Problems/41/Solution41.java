import java.util.*;
class Song{
    private int songId;
    private String title;
    private String artist;
    private double duration;
    public Song(int songId, String title, String artist, double duration){
        this.songId = songId;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
    public int getSongId(){return songId;}
    public String getTitle(){return title;}
    public String getArtist(){return artist;}
    public double getDuration(){return duration;}
}
public class Solution41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Song[] songs = new Song[5];
        for(int i=0;i<5;i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble(); sc.nextLine();
            songs[i] = new Song(a,b,c,d);
        }
        String artist1 = sc.nextLine();
        String artist2 = sc.nextLine();
        double duration = findSongDurationForArtist(songs, artist1);
        if(duration>0) System.out.println(duration);
        else System.out.println("There are not songs with given artist");

        Song[] songs2 = getSongInAscendingOrder(songs,artist2);
        if(songs2 != null){
            for(Song s:songs2){
                System.out.println(s.getSongId());
                System.out.println(s.getTitle());
            }
        }
        else System.out.println("There are no songs with given artist");
        sc.close();
    }
    public static double findSongDurationForArtist(Song[] songs, String artist){
        double sum = 0;
        for(Song s:songs){
            if(s.getArtist().equalsIgnoreCase(artist)){
                sum+=s.getDuration();
            }
        }
        return sum;
    }
    public static Song[] getSongInAscendingOrder(Song[] songs, String artist){
        Song[] fS = Arrays.stream(songs).filter(s -> s.getArtist().equalsIgnoreCase(artist)).toArray(Song[]::new);
        if(fS.length == 0) return null;
        Arrays.sort(fS, (s1, s2) -> Double.compare(s1.getDuration(), s2.getDuration()));
        return fS;
    }
}
