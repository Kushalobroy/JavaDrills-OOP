import java.util.*;
class Student{
    private int rollNo;
    private String name;
    private String branch;
    private double score;
    private boolean dayScholar;
    public Student(int rollNo, String name, String branch, double score, boolean dayScholar){
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
        this.score = score;
        this.dayScholar = dayScholar;
    }
    public boolean getIsDayScholar(){return dayScholar;}
    public double getScore(){return score;}
    public int getRollNo(){return rollNo;}
    public String getName(){return name;}

}

public class Solution15 {
    public static void main(String[] args) {
        Student[] students = new Student[4];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<4;i++){
            int rollNo = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String branch = sc.nextLine();
            double score = sc.nextDouble();
            sc.nextLine();
            boolean dayScholar = sc.nextBoolean();
            students[i] = new Student(rollNo, name, branch, score, dayScholar);
        }
        sc.close();
        int count = findCoundOfDayscholarStudents(students);
        if(count>0) System.out.println(count);
        else System.out.println("There are no such dayscholar students");

        Student[] secondHighest = findStudentwithSecondHighestScore(students);
        if(secondHighest !=null){
            for(Student s:secondHighest){
                System.out.println(s.getRollNo()+"#"+s.getName()+"#"+s.getScore());
            }
        }
        else System.out.println("There are no student from non day scholar");
    }
    public static Student[] findStudentwithSecondHighestScore(Student[] students){
        Student[] filterStudents = Arrays.stream(students).filter(s -> s.getIsDayScholar() == false).toArray(Student[]::new);
        Arrays.sort(filterStudents, (s1, s2)->Double.compare(s2.getScore(), s1.getScore()));
        double sH = filterStudents[1].getScore();
        Student[] fS  = Arrays.stream(filterStudents).filter(s -> s.getScore() == sH).toArray(Student[]::new);
        if(fS == null) return null;
        return fS;
    }
    public static int findCoundOfDayscholarStudents(Student[] students){
        int count = 0;
        Student[] filterStudents = Arrays.stream(students).filter(s -> s.getIsDayScholar() == true && s.getScore()>80).toArray(Student[]::new);
        count = filterStudents.length;
        return count;
    }
}