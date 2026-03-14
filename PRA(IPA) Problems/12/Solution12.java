import java.util.*;
class Employee2{
    private int employeeId;
    private String name;
    private String branch;
    private double rating;
    private boolean companyTransport;
    public Employee2(int employeeId, String name, String branch, double rating, boolean companyTransport){
        this.employeeId = employeeId;
        this.name = name;
        this.branch = branch;
        this.rating = rating;
        this.companyTransport = companyTransport;
    }
    public String getBranch(){return branch;}
    public boolean getCompanyTransport(){return companyTransport;}
    public int getEmployeeId(){return employeeId;}
    public String getName(){return name;}
    public double getRating(){return rating;}
}
public class Solution12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee2[] employees = new Employee2[4];
        for(int i=0;i<4;i++){
            int employeeId = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String branch = sc.nextLine();
            double rating = sc.nextDouble();
            sc.nextLine();
            boolean companyTransport = sc.nextBoolean();
            sc.nextLine();
            employees[i] = new Employee2(employeeId, name, branch, rating, companyTransport);
        }
        String br = sc.nextLine();
        int count = findCountOfEmployeesUsingCompTransport(employees, br);
        if(count>0) System.out.println(count);
        else System.out.println("No such Employees");

        Employee2[] secondHighestEmployee = findEmployeeWithSecondHighestRating(employees);
        if(secondHighestEmployee !=null){
            for(Employee2 e:secondHighestEmployee){
                System.out.println(e.getEmployeeId());
                System.out.println(e.getName());
            }
        }
        else{
            System.out.println("All Employees using company transport");
        }
        sc.close();
    }
    public static Employee2[] findEmployeeWithSecondHighestRating(Employee2[] employees){
        Employee2[] fl = Arrays.stream(employees).filter(e -> e.getCompanyTransport() == false).toArray(Employee2[]::new);
         Arrays.sort(fl, (e1,e2) -> Double.compare(e2.getRating(), e1.getRating()));
        Employee2[] filteredEmployees = fl;
         double secondHighestEmployees = filteredEmployees[1].getRating();

        Employee2[] filtered = Arrays.stream(employees).filter(e -> e.getRating() == secondHighestEmployees).toArray(Employee2[]::new);
        if(filtered == null) return null;
        return filtered;
    }

    public static int findCountOfEmployeesUsingCompTransport(Employee2[] employees, String branch){
        int count = 0;
        Employee2[] filteredEmployees = Arrays.stream(employees).filter(e ->e.getBranch().equalsIgnoreCase(branch) && e.getCompanyTransport()==true).toArray(Employee2[]::new);
        for(Employee2 e:filteredEmployees){
            count++;
            e.getBranch();
        }
        return count;
    }
}
