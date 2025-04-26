import java.util.*;

public class Solution41 {
    static class Student{
        private String name;
        private String rollNo;
        private int age;
        private char gender;
        private String course;
        private int semester;
        private double GPA;

        public Student(String name, String rollNo, int age, char gender,String course, int semester, double GPA){
            this.name = name;
            this.rollNo = rollNo;
            this.age = age;
            this.gender = gender;
            this.course = course;
            this.semester = semester;
            this.GPA = GPA;
        }
        public double getGPA(){return GPA;}
        public String  getCourse(){return course;}
        public String getName(){return name;}
        public String getRollNo(){return rollNo;}
    }   
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[4];
        for(int i=0;i<4;i++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt(); sc.nextLine();
            char d = sc.nextLine().charAt(0);
            String e = sc.nextLine();
            int f = sc.nextInt(); sc.nextLine();
            double g = sc.nextDouble(); sc.nextLine();
            students[i] = new Student(a,b,c,d,e,f,g);
        }
        String course = sc.nextLine();
        
        double avg = calculateAverageGPA(students);
        if(avg !=0 ){
            System.out.println(avg);
        }
        else{
            System.out.println("Sorry - No students are available!");
        }
        Student[] s2 = getStudentByCourse(students, course);
        if(s2 != null){
            for(Student i:s2){
                System.out.println(i.getName());
                System.out.println(i.getRollNo());
                System.out.println(i.getGPA());
            }
        }
        else{
            System.out.println("Sorry - No student are available for the given course!");
        }
    }
    public static Student[] getStudentByCourse(Student[] s, String c){
        Student res[] = Arrays.stream(s).filter(j -> j.getCourse().equalsIgnoreCase(c)).toArray(Student[]::new);
        return res;
    }
    public static double calculateAverageGPA(Student[] s){
        if(s.length == 0) return 0;
        double sum=0;
        for(Student i:s){
            sum+= i.getGPA();
        }
        return sum/s.length;
    }
}
