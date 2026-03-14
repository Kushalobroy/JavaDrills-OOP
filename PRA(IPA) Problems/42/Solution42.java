import java.util.*;
class HeadSets{
    public String headsetName;
    private String brand;
    private int price;
    private boolean available;
    public HeadSets(String headsetName, String brand, int price, boolean available){
        this.headsetName = headsetName;
        this.brand = brand;
        this.price = price;
        this.available = available;
    }
    public int getPrice(){return price;}
    public boolean isAvailable(){return available;}
    public String getHeadsetName(){return headsetName;}
    public String getBrand(){return brand;}
}
public class Solution42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HeadSets[] headSets = new HeadSets[4];
        for(int i=0;i<4;i++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            boolean d = sc.nextBoolean(); sc.nextLine();
            headSets[i] = new HeadSets(a,b,c,d);
        }
        String brand = sc.nextLine();
        int totalPrice = findTotalPriceForGivenBrand(headSets, brand);
        if(totalPrice>0) System.out.println(totalPrice);
        else System.out.println("No Headsets available with the given brand");

        HeadSets[] headSets2 = findAvailableHeadsetWithSecondMinPrice(headSets);
        if(headSets2 != null){
            for(HeadSets h:headSets2){
                System.out.println(h.getHeadsetName());
                System.out.println(h.getPrice());
            }
        }
        else System.out.println("No Headesets available");
        sc.close();
    }
    public static HeadSets[] findAvailableHeadsetWithSecondMinPrice(HeadSets[] headSets){
        Arrays.sort(headSets, (h1,h2)->Integer.compare(h1.getPrice(), h2.getPrice()));
        int sM = headSets[1].getPrice();
        HeadSets[] fH = Arrays.stream(headSets).filter(h -> h.getPrice() == sM).toArray(HeadSets[]::new);
        if(fH.length == 0) return null;
        return fH;
    }
    public static int findTotalPriceForGivenBrand(HeadSets[] headSets, String brand){
        HeadSets[] fS = Arrays.stream(headSets).filter(h -> h.getBrand().equalsIgnoreCase(brand)).toArray(HeadSets[]::new);
        if(fS.length == 0) return 0;
        int totalPrice = 0;
        for(HeadSets h:fS){
            totalPrice +=h.getPrice();
        }
        return totalPrice;
    }
}
