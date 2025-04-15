public class Solution48{
    class BankAccount{
        private int accountNumber;
        private String accountHolderName;
        private double balance;

        public  BankAccount(int accountNumber, String accountHolderName, double balance){
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
            String b = sc.nextLine();
            double c = sc.nextDouble();
            bankaccounts[i] = new BankAccount(a,b,c);
        }
        int a1 = sc.nextInt();
        double b1 = sc.nextDouble();
        int a2 = sc.nextInt();
        double b2 = sc.nextDouble();

        
    }
}