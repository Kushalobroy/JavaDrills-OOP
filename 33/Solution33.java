import java.util.*;
class Account{
    private int id;
    private double balance;
    private double interestRate;
    public Account(int id, double balance, double interestRate) {
        this.id = id;
        this.balance = balance;
        this.interestRate = interestRate;
    }
    public double getInterestRate(){return interestRate;}
}
public class Solution33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account[] accounts = new Account[1];
        for (int i = 0; i < 1; i++) {
            int id = sc.nextInt(); sc.nextLine();
            double balance = sc.nextDouble(); sc.nextLine();
            double interestRate = sc.nextDouble(); sc.nextLine();
            accounts[i] = new Account(id, balance, interestRate);
        }
        int time = sc.nextInt(); sc.nextLine();
        double interest = calculateTotalInterest(accounts, time);
        System.out.println("Total interest: " + interest );
        sc.close();
    }
    public static double calculateTotalInterest(Account[] accounts, int time){
        double per = (accounts[0].getInterestRate()/100) * time;
        per = accounts[0].getInterestRate()+per;
        return per;
    }
}
