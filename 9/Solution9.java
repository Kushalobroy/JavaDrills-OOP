import java.util.*;
public class Solution9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AutonomousCar[] autonomousCars = new AutonomousCar[4];
        for(int i=0;i<4;i++){
            int carId = sc.nextInt();
            sc.nextLine();
            String brand = sc.nextLine();
            int noOfTestsConducted = sc.nextInt();
            sc.nextLine();
            int noOfTestsPassed = sc.nextInt();
            sc.nextLine();
            String environment = sc.nextLine();
            autonomousCars[i] = new AutonomousCar(carId,brand,noOfTestsConducted,noOfTestsPassed,environment);  
        }
        String environment = sc.nextLine();
        String brand = sc.nextLine();
        int sum = findTestPassedByEnv(autonomousCars, environment);
        if(sum>0) System.out.println(sum);
        else System.out.println("There are no tests passed in this particular environment");

        AutonomousCar[] autonomousCars2 = updateCarGrade(autonomousCars, brand);
        if(autonomousCars2 != null){
            for(AutonomousCar c:autonomousCars2) System.out.println(c.getBrand()+"::"+c.getGrade());
        }else System.out.println("No Car is available with the specified brand");
    }
    public static AutonomousCar[] updateCarGrade(AutonomousCar[] autonomousCars, String brand){
        AutonomousCar[] filteredAutonomousCars = Arrays.stream(autonomousCars).filter(c -> c.getBrand().equalsIgnoreCase(brand)).toArray(AutonomousCar[]::new);
        if(filteredAutonomousCars.length == 0) return null;
        for(AutonomousCar c:filteredAutonomousCars){
            int rating = (c.getNoOfTestsPassed() * 100)/c.getNoOfTestsConducted();
            if(rating>=80){
                c.setGrade("A1");
            }
            else{
                c.setGrade("B2");
            }
        }
        return filteredAutonomousCars;
    }
    public static int findTestPassedByEnv(AutonomousCar[] autonomousCars, String environment){
        int sum = 0;
        AutonomousCar[] filteredAutonomousCars = Arrays.stream(autonomousCars).filter(c -> c.getEnvironment().equalsIgnoreCase(environment)).toArray(AutonomousCar[]::new);
        for (AutonomousCar car : filteredAutonomousCars) {
            sum += car.getNoOfTestsPassed();
        }
        return sum;
    }
}
class AutonomousCar{
    private int carId;
    private String brand;
    private int noOfTestsConducted;
    private int noOfTestsPassed;
    private String environment;
    private String grade;
    public AutonomousCar(int carId, String brand, int noOfTestsConducted, int noOfTestsPassed, String environment){
        this.carId = carId;
        this.brand = brand;
        this.noOfTestsConducted = noOfTestsConducted;
        this.noOfTestsPassed = noOfTestsPassed;
        this.environment = environment;
    }
    public String getEnvironment(){return environment;}
    public String getBrand(){return brand;}
    public int getNoOfTestsPassed(){return noOfTestsPassed;}
    public int getNoOfTestsConducted(){return noOfTestsConducted;}
    public void setGrade(String grade){
        this.grade = grade;
    }
    public String getGrade(){return grade;}
}
