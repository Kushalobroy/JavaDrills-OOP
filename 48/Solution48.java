import java.util.*;
public class Solution48{
    static class BankAccount{
        private int accountNumber;
        private String accountHolderName;
        private double balance;

        public BankAccount(int accountNumber, String accountHolderName, double balance){
            this.accountNumber = accountNumber;
            this.accountHolderName = accountHolderName;
            this.balance = balance;
        }
        public int getAcc(){
            return accountNumber;
        }
        public String getName(){
            return accountHolderName;
        }
        public double getBalance(){
            return balance;
        }
        public void setAcc(int accountNumber){
            this.accountNumber = accountNumber;
        }
        public void setName(String name){
            this.accountHolderName = name;
        }
        public void setBalance(double balance){
            this.balance = balance;
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BankAccount[] bankaccounts = new BankAccount[3];
        for(int i=0;i<3;i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            double c = sc.nextDouble();
            sc.nextLine();
            bankaccounts[i] = new BankAccount(a,b,c);
        }
        int a1 = sc.nextInt(); sc.nextLine();
        double b1 = sc.nextDouble();sc.nextLine();
        int a2 = sc.nextInt();sc.nextLine();
        double b2 = sc.nextDouble();sc.nextLine();
        
        double c1 = withdraw(bankaccounts, a1, b1);
        if(c1 != -1){
            System.out.println("Withdrawn successfully. Remaining balance: " + c1);
        }
        else{
            System.out.println("Sorry - Insufficient balance");
        }
        double c2 = deposite(bankaccounts, a2, b2);
        if(c2 != -1){
            System.out.println("Deposited successfully. New balance: " + c2);
        }
        else{
            System.out.println("Sorry - Account not found");
        }
        
    }
    public static double deposite(BankAccount[] bankaccounts, int accountNumber, double amount){
        for(int i=0;i<bankaccounts.length;i++){
            if(bankaccounts[i].getAcc() == accountNumber){
                bankaccounts[i].setBalance(bankaccounts[i].getBalance() + amount);
                return bankaccounts[i].getBalance() + amount;
                
            }
        }
        return -1;
    }
    public static double withdraw(BankAccount[] bankaccounts, int accountNumber, double amount){
        for(int i=0;i<bankaccounts.length;i++){
            if(bankaccounts[i].getAcc() == accountNumber){
                if(bankaccounts[i].getBalance() >= amount){
                    bankaccounts[i].setBalance(bankaccounts[i].getBalance() - amount);
                    return  bankaccounts[i].getBalance() - amount;
                    
                }
            }
        }
        return -1;
    }
}