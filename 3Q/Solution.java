import java.util.*;

class Course{
    private int courseId;
    private String courseName;
    private String courseAdmin;
    private int quiz;
    private int handson;
    public Course(int courseId, String courseName, String courseAdmin, int quiz, int handson){
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseAdmin = courseAdmin;
        this.quiz = quiz;
        this.handson = handson;
    }
    public int getHandson(){return handson;}
    public String getCourseAdmin(){return courseAdmin;}
    public int getQuiz(){return quiz;}
    public String getCourseName() {return courseName;}
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Course[] courses = new Course[4];
        for(int i=0;i<4;i++){
            int courseId = sc.nextInt();
            sc.nextLine();
            String courseName = sc.nextLine();
            String courseAdmin = sc.nextLine();
            int quiz = sc.nextInt();
            sc.nextLine();
            int handson = sc.nextInt();
            sc.nextLine();
            courses[i] = new Course(courseId, courseName, courseAdmin, quiz, handson);
        }
        String admin = sc.nextLine();
        int handsonInput = sc.nextInt();
        double avg = findAvgOfQuizByAdmin(courses, admin);
        if(avg>0) System.out.println((int)avg);
        else System.out.println("No Courses found");
        Course[] courses2 = sortCourseByHandsOn(courses, handsonInput);
        if(courses2 !=null){
            for(Course course:courses2){
                System.out.println(course.getCourseName());
            }
        }
        else System.out.println("No Courses found with mentioned attribute.");
    }
    public static Course[] sortCourseByHandsOn(Course[] courses, int handson){
        Course[] filterCourses = Arrays.stream(courses).filter(c -> c.getHandson() < handson).toArray(Course[]::new);
        Arrays.sort(filterCourses, Comparator.comparingInt(Course::getHandson));
        if(filterCourses !=null) return filterCourses;
        return null;
    }

    public static double findAvgOfQuizByAdmin(Course[] courses, String admin){
        double sum = 0;
        int count=0;
        if(courses != null){
            for(Course course : courses){
                if(course.getCourseAdmin().equals(admin)){
                    sum+=course.getQuiz();
                    count++;
                }
            }
        }
        return sum/count;
    }
}
