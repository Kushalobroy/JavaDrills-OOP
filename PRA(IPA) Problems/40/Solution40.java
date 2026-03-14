import java.util.*;
class MobileDetails{
    private int MobileId;
    private int Price;
    private String Brand;
    private boolean isFlagShip;
    public MobileDetails(int MobileId, int Price, String Brand, boolean isFlagShip){
        this.MobileId = MobileId;
        this.Price = Price;
        this.Brand = Brand;
        this.isFlagShip = isFlagShip;
    }
    public int getId(){return MobileId;}
    public int getPrice(){return Price;}
    public String getBrand(){return Brand;}
    public boolean getIsFlagShip(){return isFlagShip;}
}
public class Solution40{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MobileDetails[] mobileDetails = new MobileDetails[5];
        for(int i=0;i<5;i++){
            int a = sc.nextInt(); sc.nextLine();
            int b = sc.nextInt(); sc.nextLine();
            String c = sc.nextLine();
            boolean d = sc.nextBoolean(); sc.nextLine();
            mobileDetails[i] = new MobileDetails(a, b, c, d);
        }
        String br= sc.nextLine();

        int totalPrice = getTotalPrice(mobileDetails, br);
        if(totalPrice>0) System.out.println(totalPrice);
        else System.out.println("There are not mobile with given brand");

        MobileDetails[] mobileDetails2 = getSecondMin(mobileDetails);
        if(mobileDetails2 != null){
            for(MobileDetails m:mobileDetails2){
                System.out.println(m.getBrand()+" : "+m.getPrice());
            }
        }
        else System.out.println("There is no Second Min available");

        sc.close();
    }
    public static MobileDetails[] getSecondMin(MobileDetails[] mobileDetails){
        Arrays.sort(mobileDetails, (m1,m2) -> Integer.compare(m1.getPrice(), m2.getPrice()));
        if(mobileDetails.length<2) return null;
        int sM = mobileDetails[1].getPrice();
        MobileDetails[] fM = Arrays.stream(mobileDetails).filter(m -> m.getPrice() == sM).toArray(MobileDetails[]::new);
        return fM;
    }
    public static int getTotalPrice(MobileDetails[] mobileDetails, String brand){ 
        MobileDetails[] fM = Arrays.stream(mobileDetails).filter(m -> m.getBrand().equalsIgnoreCase(brand)).toArray(MobileDetails[]::new);
        if(fM.length == 0) return 0;
        int totalPrice=0;
        for(MobileDetails a:fM) totalPrice+=a.getPrice();
        return totalPrice; 
    }

}