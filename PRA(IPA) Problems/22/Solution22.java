import java.util.*;
class Student{
    private int rollNo;
    private String name;
    private String subject;
    private char grade;
    private String date;
    public Student(int rollNo, String name, String subject, char grade, String date) {
        this.rollNo = rollNo;
        this.name = name;
        this.subject = subject;
        this.grade = grade;
        this.date = date;
    }
    public int getRollNo(){return rollNo;}
    public String getDate(){return date;}
    public String getName(){return name;}
    public char getGrade(){return grade;}
    public String getSubject(){return subject;}
}
public class Solution22 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[4];
        for(int i=0;i<4;i++){
            int rollNo = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String subject = sc.nextLine();
            char grade = sc.next().charAt(0);
            sc.nextLine();
            String date = sc.nextLine();
            students[i] = new Student(rollNo, name, subject, grade, date);
        }
        char gd = sc.next().charAt(0);
        int month = sc.nextInt();
        sc.close();
        Student[] students2 = findStudentByGradeAndMonth(students, gd, month);
        if(students2 != null){
            for(Student s: students2){
                System.out.println(s.getName());
                System.out.println(s.getSubject());
            }
            System.out.println(students2.length);
        }
        else System.out.println("No student found");
    }
    public static Student[] findStudentByGradeAndMonth(Student[] students, char grade, int month){
        Student[] fS = Arrays.stream(students).filter(s -> Integer.parseInt(s.getDate().split("/")[1]) == month && s.getGrade()==grade).toArray(Student[]::new);
        if(fS.length == 0) return null;
        Arrays.sort(fS, (s1, s2)-> Integer.compare(s1.getRollNo(), s2.getRollNo()));
        return fS;
    }
}