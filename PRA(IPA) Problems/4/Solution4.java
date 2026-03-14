import java.util.*;

class NavalVessel{
    private int vesselId;
    private String vesselName;
    private int noOfVoyagesPlanned;
    private int noOfVoyagesCompleted;
    private String purpose;

    public NavalVessel(int vesselId, String vesselName, int noOfVoyagesPlanned, int noOfVoyagesCompleted, String purpose){
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.noOfVoyagesPlanned = noOfVoyagesPlanned;
        this.noOfVoyagesCompleted = noOfVoyagesCompleted;
        this.purpose = purpose;
    }
    public int getNoOfVoyagesPlanned(){return noOfVoyagesPlanned;}
    public int getNoOfVoyagesCompleted(){return noOfVoyagesCompleted;}
    public String getPurpose(){return purpose;}
    public String getVesselName(){return vesselName;}
    public int getId(){return vesselId;}
}
public class Solution4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        NavalVessel[] navalVessels = new NavalVessel[4];
        for(int i=0;i<4;i++){
            int vesselId = sc.nextInt();
            sc.nextLine();
            String vesselName = sc.nextLine();
            int noOfVoyagesPlanned = sc.nextInt();
            sc.nextLine();
            int noOfVoyagesCompleted = sc.nextInt();
            sc.nextLine();
            String purpose = sc.next();
            navalVessels[i] = new NavalVessel(vesselId, vesselName, noOfVoyagesPlanned, noOfVoyagesCompleted, purpose);
        }
        int percentage = sc.nextInt();
        sc.nextLine();
        String ps = sc.nextLine();
        int avg = findAvgVoyagesByPct(navalVessels, percentage);
        if(avg>0) System.out.println(avg);
        else System.out.println("Criteria Not fullfilled");
        NavalVessel[] navalVessels2 = findVesselByGrade(navalVessels, ps);
        if(navalVessels2 != null)
        for(NavalVessel n:navalVessels2){
            int p = (n.getNoOfVoyagesCompleted() * 100)/n.getNoOfVoyagesPlanned();
            
            if(p==100) {
                System.out.println(n.getVesselName()+"%"+"Star");
            }
            if(p>=80 && p<=99){ 
                System.out.println(n.getVesselName()+"%"+"Leader");
            }
            if(p<=79 && p>=55) System.out.println(n.getVesselName()+"%"+"Inspirer");
            if(p<55 ) System.out.println(n.getVesselName()+"%"+"Striver");
        }
        else System.out.println("No Naval Vessel is available with the specified purpose");
sc.close();
    }  
    
    public static NavalVessel[] findVesselByGrade(NavalVessel[] navalVessels, String ps){
        NavalVessel[] filteredNavalVessels = Arrays.stream(navalVessels).filter(p -> p.getPurpose().equalsIgnoreCase(ps)).toArray(NavalVessel[]::new);
        return filteredNavalVessels;
    }
    public static int findAvgVoyagesByPct(NavalVessel[] navalVessels, int percentage){
        int count = 0;
        int sum = 0;
        for(NavalVessel n: navalVessels){
            int p = (n.getNoOfVoyagesCompleted() * 100)/n.getNoOfVoyagesPlanned();
            if(p >= percentage) {
                count++;
                sum += n.getNoOfVoyagesCompleted();
            }
        }
        return sum/count;
    }  
}
