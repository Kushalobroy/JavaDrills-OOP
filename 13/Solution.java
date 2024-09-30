import java.util.*;
class Institution
{
    private int institutionId;
    private String institutionName;
    private int noOfStudentsPlaced;
    private int noOfStudentsCleared;
    private String location;
    private String grade;

    public Institution(int institutionId, String institutionName, int noOfStudentsPlaced, int noOfStudentsCleared, String location){
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.noOfStudentsPlaced = noOfStudentsPlaced;
        this.noOfStudentsCleared = noOfStudentsCleared;
        this.location = location;
    }
    public void setGrade(String grade){this.grade = grade;}
    public String getLocation(){return location;}
    public int getNoOfStudentsCleared(){return noOfStudentsCleared;}
    public int getNoOfStudentsPlaced(){return noOfStudentsPlaced;}
    public String getInstitutionName(){return institutionName;}
    public String getGrade(){return grade;}
}
public class Solution
{

public static void main(String[] args)
{
    Scanner sc = new Scanner(System.in);
    Institution[] institutions = new Institution[4];
    for(int i=0;i<4;i++){
        int institutionId = sc.nextInt();
        sc.nextLine();
        String instituteName = sc.nextLine();
        int noOfStudentsPlaced = sc.nextInt();
        sc.nextLine();
        int noOfStudentsCleared = sc.nextInt();
        sc.nextLine();
        String location = sc.nextLine();
    
        institutions[i]= new Institution(institutionId, instituteName, noOfStudentsPlaced, noOfStudentsCleared, location);
    }
    String locatioString = sc.nextLine();
    String institutionName = sc.nextLine();

    int cl = findNumClearancedByLoc(institutions, locatioString);
    if(cl>0) System.out.println(cl);
    else System.out.println("There are not cleared students in this particular location");

    Institution[] fl = updateInstitutionGrade(institutions, institutionName);
    if(fl != null){
        for(Institution i:fl){
            System.out.println(i.getInstitutionName()+"::"+i.getGrade());
        }
    }
    else System.out.println("No Institue is available with the specified name");
    sc.close();
}

public static int findNumClearancedByLoc(Institution[] institutions, String location)
{
    Institution[] filtered = Arrays.stream(institutions).filter(i -> i.getLocation().equalsIgnoreCase(location)).toArray(Institution[]::new);
   
    int sum = 0;
    for(Institution i:filtered){
        sum+=i.getNoOfStudentsCleared();
    }
    return sum;
}

public static Institution[] updateInstitutionGrade(Institution[] institutions, String institutionName)
{
    Institution[] filtered = Arrays.stream(institutions).filter(i -> i.getInstitutionName().equalsIgnoreCase(institutionName)).toArray(Institution[]::new);
    for(Institution i: filtered){
        int rating = (i.getNoOfStudentsPlaced() * 100)/ i.getNoOfStudentsCleared() ;
        if(rating >=80) i.setGrade("A");
        else i.setGrade("B");
    }
    return filtered;
}
}

