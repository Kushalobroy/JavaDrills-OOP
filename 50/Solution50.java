import java.util.*;
public class Solution50{
    class Person{
        private String firstName;
        private String lastName;
        private int age;
        private char gender;
        public Person(String firstname, String lastName, int age, char gender){
            this.firstName = firstname;
            this.lastName = lastName;
            this.age = age;
            this.gender = gender;
        }
        public String getFirstName(){return firstName;}
        public String getLastName(){return lastName;}
        public int getAge(){return age;}
        public char getGender(){return gender;}
    }
    class Student{
        private String rollNo;
        private String course;
        private int semester;
        private double gpa;
        public Student(String rollNo, String course, int semester, double gpa){
            this.rollNo = rollNo;
            this.course = course;
            this.semester = semester;
            this.gpa = gpa;
        }
        public String getRollNo(){return rollNo;}
        public String getCourse(){return course;}
        public int getSemester(){return semester;}
        public double getGpa(){return gpa;}
    }
    class Faculty{
        private String employeeId;
        private String department;
        private String designation;
        private double salary;
        public Faculty(String employeeId, String department, String designation, double salary){
            this.employeeId = employeeId;
            this.department = department;
            this.designation = designation;
            this.salary = salary;
        }
        public String getEmployeeId(){return employeeId;}
        public String getDepartment(){return department;}
        public String getDesignation(){return designation;}
        public double getSalary(){return salary;}
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }
}