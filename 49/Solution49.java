import java.util.*;
public class Solution49{
    static class Vehicle{
        private int number;
        private String name;
        private double price;

        public Vehicle(int number, String name, double price) {
            this.number = number;
            this.name = name;
            this.price = price;
        }
        public int getNumber() {
            return number;
        }
        public String getName() {
            return name;
        }
        public double getPrice() {
            return price;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Vehicle[] vehicles = new Vehicle[4];
        for(int i=0;i<n;i++){
            int number = sc.nextInt();
            String name = sc.next();
            double price = sc.nextDouble();
            vehicles[i] = new Vehicle(number, name, price);
        }
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println("Output------------------------");
        Vehicle[] v1 = findVehicleByMinimumPrice(vehicles);
        if(v1 != null){
            
            for(Vehicle v: v1){
                System.out.println("number -"+v.getNumber());
                System.out.println("name -"+v.getName());
                System.out.println("price -"+v.getPrice());
                
            }
        }
        else{
            System.out.println("No vehicle found with mentioned attributes");
        }
        Vehicle[] v2 = searchVehicleByName(vehicles, s);
        if(v2 != null){
            for(Vehicle c: v2){
                System.out.println("number -"+c.getNumber());
                System.out.println("name -"+c.getName());
                System.out.println("price -"+c.getPrice());
                
            }
        }
        else{
            System.out.println("No vehicle found with mentioned attributes");
        }
    }
    public static Vehicle[] findVehicleByMinimumPrice(Vehicle[] v){
        if(v.length == 0 ) return null;
        Arrays.sort(v, (v1, v2) -> Double.compare(v1.getPrice(), v2.getPrice()));
        double minprice = v[0].getPrice();
        return Arrays.stream(v)
            .filter(v1 -> v1.getPrice() == minprice)
            .toArray(Vehicle[]::new);
    }

    public static Vehicle[] searchVehicleByName(Vehicle[] v, String s){
        if(v.length == 0) return null;
        return Arrays.stream(v).filter(v1 -> v1.getName().equalsIgnoreCase(s))
            .toArray(Vehicle[]::new);
    }
}