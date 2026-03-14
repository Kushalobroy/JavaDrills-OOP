import java.util.*;
class TravelAgencies{
    private int regNo;
    private String agencyName;
    private String packageType;
    private int price;
    private boolean flightFacility;
    public TravelAgencies(int regNo, String agencyName, String packageType, int price, boolean flightFacility){
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.packageType = packageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }
    public int getRegNo(){return regNo;}
    public String getAgencyName(){return agencyName;}
    public String getPackageType(){return packageType;}
    public int getPrice(){return price;}
    public boolean isFlightFacility(){return flightFacility;}
}
public class Solution36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TravelAgencies[] travelAgencies = new TravelAgencies[4];
        for(int i=0;i<4;i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            boolean e = sc.nextBoolean();
            travelAgencies[i] = new TravelAgencies(a,b,c,d,e);
        }
        int reg = sc.nextInt(); sc.nextLine();
        String type = sc.nextLine();
        int hS = findAgencyWithHighestPackagePrice(travelAgencies);
        if(hS>0) System.out.println(hS);

        TravelAgencies[] travelAgencies2 = agencyDetailsForGivenIdAndType(travelAgencies, reg, type);
        if(travelAgencies2 != null){
            for (TravelAgencies travelAgency : travelAgencies2) {
                System.out.println(travelAgency.getAgencyName()+":"+travelAgency.getPrice());
            }
        }
        else System.out.println("No - Agency available with given type");
        sc.close();
    }
    public static TravelAgencies[] agencyDetailsForGivenIdAndType(TravelAgencies[] t, int reg, String type){
        TravelAgencies[] fT = Arrays.stream(t).filter(a -> a.getRegNo()==reg && a.getPackageType().equalsIgnoreCase(type) && a.isFlightFacility()).toArray(TravelAgencies[]::new);
       // if(fT.length == 0) return null;
        return fT;
    }
    public static int findAgencyWithHighestPackagePrice(TravelAgencies[] t){
        Arrays.sort(t, (t1, t2) -> Integer.compare(t2.getPrice(), t1.getPrice()));
        return t[0].getPrice();
    }

}
