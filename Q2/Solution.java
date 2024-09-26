import java.util.*;
class Employee{
    private int id;
    private String name;
    private String designation;
    private double salary;
    
    public Employee(int id, String name, String designation, double salary ){
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }
    public int getId(){return id;}
    public void setId(int id){this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDesignation() {return designation;}
    public void setDesignation(String designation) {this.designation = designation;}
    public double getSalary(){return salary;}
    public void setSalary(){this.salary = salary;}
}
class Company{
    private String companyName;
    private Employee[] employees;
    private int numEmployees;
    public Company(String companyName, Employee[] employees, int numEmployees){
        this.companyName = companyName;
        this.employees = employees;
        this.numEmployees = numEmployees;
    }
    public double getAverageSalary(Employee[] e){
        
        double sum=0;
        for(int i=0;i<e.length;i++){ sum+=e[i].getSalary();}
        if(sum>0){
            double avg = sum / e.length;
            return avg;
        }
        return 0;   
    }
    public double getMaxSalary(Employee[] e){
        double max = e[0].getSalary();
        for(int i=0;i<e.length;i++){
            if(e[i].getSalary()>max){max=e[i].getSalary();}
        }
        return max;
    }
    public Employee[] getEmployeesByDesignation(Employee[] employees, String des){
        // Employee[] emp = new Employee[0];
        // for(int i=0;i<e.length;i++){
        //     if(e[i].getDesignation().equalsIgnoreCase(des)){
        //         emp = Arrays.copyOf(emp, emp.length+1);
        //         emp[emp.length-1] = e[i];
        //     }
        // }
        // if(emp.length > 0) return emp;
        // return null;
        return Arrays.stream(employees).filter(e -> e.getDesignation().equalsIgnoreCase(des)).toArray(Employee[]::new);
    }
}
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter company name: ");
        String cn = sc.nextLine();
        System.out.print("Enter number of employees: ");
        int num = sc.nextInt();sc.nextLine();
        Employee[] emp = new Employee[num];
        System.out.println("Enter employee details: ");
        for (int i = 0; i < emp.length; i++) {
            System.out.println("Employee "+(i+1)+":");

            System.out.print("Enter id: ");
            int a = sc.nextInt();sc.nextLine();

            System.out.print("Enter name: ");
            String b = sc.nextLine();

            System.out.print("Enter designation: ");
            String c = sc.nextLine();

            System.out.print("Enter salary: ");
            double d = sc.nextDouble();sc.nextLine();

            emp[i] = new Employee(a,b,c,d);
        }
        Company com = new Company(cn,emp,num);
    
        System.out.println("Average Salary : "+com.getAverageSalary(emp));
        System.out.println("Max Salary : "+com.getMaxSalary(emp));

        System.out.print("Enployee with Designation: ");
        String desi = sc.nextLine();
        Employee[] ans = com.getEmployeesByDesignation(emp,desi);
        if(ans!=null)
        {
            for (int i = 0; i < ans.length; i++) {
                System.out.println("ID: "+ans[i].getId()+", Name: "+ans[i].getName()+", Designation: "+ans[i].getDesignation()+", Salary: "+ans[i].getSalary());
            }
        }
    }
}
