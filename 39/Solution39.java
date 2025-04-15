import java.util.*;
class Car2{
    private int carId;
    private String carName;
    private String fuelType;
    public Car2(int carId, String carName, String fuelType){
        this.carId = carId;
        this.carName = carName;
        this.fuelType = fuelType;
    }
    public int getCarId(){return carId;}
    public String getCarName(){return carName;}
    public String getFuelType(){return fuelType;}
}
public class Solution39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car2[] cars = new Car2[5];
        for(int i=0;i<5;i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            cars[i] = new Car2(a,b,c);
        }
        int id = sc.nextInt();
        Car2[] ans = RemoveAndRearrange(cars, id);
        if(ans != null){
            for(int i=0;i<ans.length;i++)
                System.out.println(cars[i].getCarId()+":"+ans[i].getCarName());
        }
        else System.out.println("There are not car with given id");
        sc.close();
    }
    public static Car2[] RemoveAndRearrange(Car2[] cars, int id){
        Car2[] arr = new Car2[0];
        for(int i=0;i<cars.length;i++){
            if(cars[i].getCarId() != id){
                arr = Arrays.copyOf(arr, arr.length+1);
                arr[arr.length-1] = cars[i];
            }
        }
        if(arr.length > 0) return arr;
        return null;
    }           
}
