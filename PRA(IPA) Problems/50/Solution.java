import java.util.Scanner;

class Person {
    private String firstName;
    private String lastName;
    private int age;
    private char gender;

    public Person(String firstName, String lastName, int age, char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public char getGender() { return gender; }
    public void setGender(char gender) { this.gender = gender; }
}

class Student extends Person {
    private String rollNo;
    private String course;
    private int semester;
    private double GPA;

    public Student(String firstName, String lastName, int age, char gender,
                   String rollNo, String course, int semester, double GPA) {
        super(firstName, lastName, age, gender);
        this.rollNo = rollNo;
        this.course = course;
        this.semester = semester;
        this.GPA = GPA;
    }

    // Getters and Setters
    public String getRollNo() { return rollNo; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public int getSemester() { return semester; }
    public void setSemester(int semester) { this.semester = semester; }

    public double getGPA() { return GPA; }
    public void setGPA(double GPA) { this.GPA = GPA; }
}

class Faculty extends Person {
    private String employeeId;
    private String department;
    private String designation;
    private double salary;

    public Faculty(String firstName, String lastName, int age, char gender,
                   String employeeId, String department, String designation, double salary) {
        super(firstName, lastName, age, gender);
        this.employeeId = employeeId;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }

    // Getters and Setters
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}

public class Solution {

    public static Student findHighestGPAStudent(Student[] students) {
        if (students == null || students.length == 0) return null;

        Student topStudent = students[0];
        for (Student s : students) {
            if (s.getGPA() > topStudent.getGPA()) {
                topStudent = s;
            }
        }
        return topStudent;
    }

    public static Faculty findHighestPaidFaculty(Faculty[] faculties) {
        if (faculties == null || faculties.length == 0) return null;

        Faculty topFaculty = faculties[0];
        for (Faculty f : faculties) {
            if (f.getSalary() > topFaculty.getSalary()) {
                topFaculty = f;
            }
        }
        return topFaculty;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for 2 Students
        Student[] students = new Student[2];
        for (int i = 0; i < 2; i++) {
            String firstName = sc.next();
            String lastName = sc.next();
            int age = sc.nextInt();
            char gender = sc.next().charAt(0);
            String rollNo = sc.next();
            String course = sc.next();
            int semester = sc.nextInt();
            double GPA = sc.nextDouble();
            students[i] = new Student(firstName, lastName, age, gender, rollNo, course, semester, GPA);
        }

        // Input for 2 Faculties
        Faculty[] faculties = new Faculty[2];
        for (int i = 0; i < 2; i++) {
            String firstName = sc.next();
            String lastName = sc.next();
            int age = sc.nextInt();
            char gender = sc.next().charAt(0);
            String employeeId = sc.next();
            String department = sc.next();
            String designation = sc.nextLine().trim(); // To consume the full line for designation
            if (designation.isEmpty()) designation = sc.nextLine().trim();
            double salary = sc.nextDouble();
            faculties[i] = new Faculty(firstName, lastName, age, gender, employeeId, department, designation, salary);
        }

        // Highest GPA Student
        Student topStudent = findHighestGPAStudent(students);
        if (topStudent != null) {
            System.out.println(topStudent.getRollNo() + " " + topStudent.getCourse() + " " + topStudent.getGPA());
        } else {
            System.out.println("Sorry - No student is available");
        }

        // Highest Paid Faculty
        Faculty topFaculty = findHighestPaidFaculty(faculties);
        if (topFaculty != null) {
            System.out.println(topFaculty.getEmployeeId() + " " + topFaculty.getDepartment() + " " + topFaculty.getSalary());
        } else {
            System.out.println("Sorry - No faculty is available");
        }
    }
}
