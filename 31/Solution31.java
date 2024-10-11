import java.util.*;
class Sim2{
    private int id;
    private String company;
    private int balance;
    private double ratePerSecond;
    private String circle;
    public Sim2(int id, String company, int balance, double ratePerSecond, String circle){
        this.id = id;
        this.company = company;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }
    public int getId(){return id;}
    public String getCompany(){return company;}
    public int getBalance(){return balance;}
    public double getRatePerSecond(){return ratePerSecond;}
    public String getCircle(){return circle;}
}
public class Solution31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sim2[] sim2s = new Sim2[4];
        for(int i=0;i<4;i++){
            int id = sc.nextInt(); sc.nextLine();
            String company = sc.nextLine();
            int balance = sc.nextInt(); sc.nextLine();
            double ratePerSecond = sc.nextDouble(); sc.nextLine();
            String circle = sc.nextLine();
            sim2s[i] = new Sim2(id, company, balance, ratePerSecond, circle);
        }
        String searchCircle = sc.nextLine();
        double searchRate = sc.nextDouble(); sc.nextLine();
        Sim2[] sim2s2 = matchAndSort(sim2s, searchCircle, searchRate);
        if(sim2s2 != null){
            for (Sim2 sim2 : sim2s2) {
                System.out.println(sim2.getId());
            }
        }
    }
    public static Sim2[] matchAndSort(Sim2[] s, String circle, double rate){
        Sim2[] fS = Arrays.stream(s).filter(a -> a.getCircle().equalsIgnoreCase(circle) && a.getRatePerSecond() < rate).toArray(Sim2[]::new);
        if(fS.length == 0) return null;
        Arrays.sort(fS, (s1, s2)-> Integer.compare(s2.getBalance(), s1.getBalance()));
        return fS;
    }
}
