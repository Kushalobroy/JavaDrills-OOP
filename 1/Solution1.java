
import java.util.Scanner;
import java.util.*;

class Employee2{
    private int employeeId;
    private String employeeName;
    private int age;
    private char gender;
    private double salary;
    public Employee2(int employeeId, String employeeName, int age, char gender, double salary){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }
    public int getEmployeeId(){ return employeeId;}
    public void setEmployeeId(int employeeId){ this.employeeId = employeeId;}
    public String getEmployeeName(){ return employeeName; }
    public int getAge(){return age;}
    public void setAge(int age){this.age = age;}
    public char getGender() {return gender;}
    public void setGender(char gender){this.gender = gender;}
    public double getSalary(){return salary;}
    public void setSalary(double salary){this.salary=salary;}
}

public class Solution1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Employee2[] employees = new Employee2[n];
        for(int i=0;i<n;i++){
            int employeeId = sc.nextInt();
            sc.nextLine();
            String employeeName = sc.nextLine();
            int age = sc.nextInt();
            sc.nextLine();
            char gender = sc.next().charAt(0);
            sc.nextLine();
            double salary = sc.nextDouble();
            employees[i] = new Employee2(employeeId, employeeName, age, gender, salary);
        }
        int ageInput = sc.nextInt();
        Employee2[] EmployeeWithSecondLowestSalary = getEmployeeWithSecondLowestSalary(employees);
        if(EmployeeWithSecondLowestSalary != null){
            for(Employee2 emp : EmployeeWithSecondLowestSalary){
                System.out.println(emp.getEmployeeId() +"#"+emp.getEmployeeName());
            }
        }else System.out.println("Null");
        int countEmployeesOnAge = getCountEmployeesOnAge(employees, ageInput);
        System.out.println(countEmployeesOnAge);
        sc.close();

    }
    public static int getCountEmployeesOnAge(Employee2[] employees,int ageInput){
         int count=0; 
        
             for(Employee2 e: employees){
if(e.getAge() == ageInput) count++;
             }
          
          return count;
    }
    public static Employee2[] getEmployeeWithSecondLowestSalary(Employee2[] employees){
        if(employees == null || employees.length <2) return new Employee2[0];
        Arrays.sort(employees, (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        double lowestSalary = employees[0].getSalary();
        double secondLowestSalary = -1;
        for(Employee2 employee : employees){
            if(employee.getSalary()>lowestSalary){
                secondLowestSalary = employee.getSalary();
                break;
            }
        }
        if(secondLowestSalary == -1) return new Employee2[0];
        double finalSecondLowestSalary = secondLowestSalary;
        return Arrays.stream(employees).filter(e -> e.getSalary() == finalSecondLowestSalary).toArray(Employee2[]::new);
    }
}
