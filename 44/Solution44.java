import java.util.*;
class Car{
    private String make;
    private String model;
    private int year;
    private double price;
    public Car(String make, String model, int year, double price){
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }
    public String getMake(){return make;}
    public String getModel(){return model;}
    public int getYear(){return year;}
    public double getPrice(){return price;}
}
public class Solution44{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car[] cars = new Car[4];
        for(int i=0;i<4;i++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt(); sc.nextLine();
            double d = sc.nextDouble(); sc.nextLine();
            cars[i] = new Car(a,b,c,d);
        }
        String make = sc.nextLine();
        String model = sc.nextLine();
        Car[] cars2 = findMostExpensiveCar(cars);
        if(cars2 != null){
            for(Car c:cars2){
                System.out.println(c.getMake());
                System.out.println(c.getModel());
                System.out.println(c.getPrice());
                System.out.println(c.getYear());
            }
        }
        else System.out.println("Sorry - No car is available");
        
        Car[] cars3 = getCarByMakeAndModel(cars, make, model);
        if(cars3 != null){
            for(Car c:cars3){
                System.out.println(c.getYear());
                System.out.println(c.getPrice());
            }
        }else System.out.println("Sorry - No car is available");
        sc.close();
    }
    public static Car[] getCarByMakeAndModel(Car[] cars, String make, String model){
        Car[] fC = Arrays.stream(cars).filter(c -> c.getMake().equalsIgnoreCase(make) && c.getModel().equalsIgnoreCase(model)).toArray(Car[]::new);
        if(fC.length == 0) return null;
        return fC;
    }
    public static Car[] findMostExpensiveCar(Car[] cars){
        if(cars.length == 0) return null;
        Arrays.sort(cars, (c1,c2)->Double.compare(c2.getPrice(), c1.getPrice()));
        double maxPrice = cars[0].getPrice();
    
        return Arrays.stream(cars)
                     .filter(car -> car.getPrice() == maxPrice)
                     .toArray(Car[]::new);
    }
}