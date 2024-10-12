import java.util.*;
class Sim{
    private int simId;
    private String customerName;
    private double balance;
    private double ratePerSecond;
    private String circle;
    public Sim(int simId, String customerName, double balance, double ratePerSecond, String circle){
        this.simId = simId;
        this.customerName = customerName;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }
    public String getCircle(){return circle;}
    public void setCircle(String circle){this.circle = circle;}
    public double getRatePerSecond(){return ratePerSecond;}
    public int getSimId(){return simId;}
    public String getCustomerName(){return customerName;}
    public double getBalance(){return balance;}
}
public class Solution19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sim[] sims = new Sim[5];
        for(int i=0;i<5;i++){
            int simId = sc.nextInt();
            sc.nextLine();
            String customerName = sc.nextLine();
            double balance = sc.nextDouble();
            sc.nextLine();
            double ratePerSecond = sc.nextDouble();
            sc.nextLine();
            String circle = sc.nextLine();
            sims[i] = new Sim(simId, customerName, balance, ratePerSecond, circle);
        }
        String circle1 = sc.nextLine();
        String circle2 = sc.nextLine();
        sc.close();

        Sim[] sims2 = transferCustomerCircle(sims, circle1, circle2);
        if(sims2 != null){
            for(Sim s:sims2){
                System.out.println(s.getSimId()+" "+s.getCustomerName()+" "+s.getCircle()+" "+s.getRatePerSecond());
            }
        }
        else System.out.println("No such circle");
    }
    public static Sim[] transferCustomerCircle(Sim[] sims, String circle1, String circle2){
        Sim[] fS = Arrays.stream(sims).filter(s -> s.getCircle().equalsIgnoreCase(circle1)).toArray(Sim[]::new);
        if(fS.length == 0) return null;
        for(Sim s: fS){
            s.setCircle(circle2);
        }
        Arrays.sort(fS, (s1, s2)-> Double.compare(s2.getRatePerSecond(), s1.getRatePerSecond()));
        return fS;
    }
}
