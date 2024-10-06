import java.util.*;
class Antenna{
    private int antennaid;
    private String antennaName;
    private String projectLead;
    private double antennaVSWR;
    public Antenna(int antennaid, String antennaName, String projectLead, double antennaVSWR){
        this.antennaid = antennaid;
        this.antennaName = antennaName;
        this.projectLead = projectLead;
        this.antennaVSWR = antennaVSWR;
    }
    public int getAntennaId(){return antennaid;}
    public String getAntennaName(){return antennaName;}
    public String getProjectLead(){return projectLead;}
    public double getAntennaVSWR(){return antennaVSWR;}
}
public class Solution23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Antenna[] antennas = new Antenna[4];
        for(int i=0;i<4;i++){
            int antennaid = sc.nextInt();
            sc.nextLine();
            String antennaName = sc.nextLine();
            String projectLead = sc.nextLine();
            double antennaVSWR = sc.nextDouble();
            sc.nextLine();
            antennas[i] = new Antenna(antennaid, antennaName, projectLead, antennaVSWR);
        }
        String antenaa = sc.nextLine();
        double VSWR = sc.nextDouble();
        sc.close();

        int id = searchAntennaByName(antennas, antenaa);
        if(id !=0){
            System.out.println(id);
        }
        else System.out.println("There is no antenna with the given parameter");
        Antenna[] antennas2 = sortAntennaByVSWR(antennas, VSWR);
        if(antennas2 != null){
            for(Antenna a:antennas2){
                System.out.println(a.getProjectLead());
            }
        }
        else System.out.println("No Antenna found");
    }
    public static Antenna[] sortAntennaByVSWR(Antenna[] antennas, double VSWR){
        Antenna[] fA = Arrays.stream(antennas).filter(a -> a.getAntennaVSWR() < VSWR).toArray(Antenna[]::new);
        if(fA.length ==0 ) return null;
        Arrays.sort(fA, (a1,a2) -> Double.compare(a1.getAntennaVSWR(), a2.getAntennaVSWR()));
        return fA;
    }
    public static int searchAntennaByName(Antenna[] antennas, String antenna){
       Antenna[] fA =  Arrays.stream(antennas).filter(a -> a.getAntennaName().equalsIgnoreCase(antenna)).toArray(Antenna[]::new);
       if(fA.length > 0){return fA[0].getAntennaId();}
       else return 0;
    }
}
