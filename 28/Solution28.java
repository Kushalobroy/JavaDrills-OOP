import java.util.*;
class Inventory{
    private String inventoryId;
    private int maximumQuantity;
    private int currentQuantity;
    private int threshold;
    public Inventory(String inventoryId, int maximumQuantity, int currentQuantity, int threshold) {
        this.inventoryId = inventoryId;
        this.maximumQuantity = maximumQuantity;
        this.currentQuantity = currentQuantity;
        this.threshold = threshold;
    }
    public int getThreshold(){return threshold;}
    public String getInventoryId(){return inventoryId;}
}
public class Solution28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory[] inventories = new Inventory[4];
        for(int i=0;i<4;i++){
            String inventoryId = sc.nextLine();
            int maximumQuantity = sc.nextInt();
            sc.nextLine();
            int currentQuantity = sc.nextInt();
            sc.nextLine();
            int threshold = sc.nextInt();
            sc.nextLine();
            inventories[i] = new Inventory(inventoryId, maximumQuantity, currentQuantity, threshold);
        }
        int limit = sc.nextInt();
        sc.nextLine();
        Inventory[] inventories2 = Replenish(inventories, limit);
        if(inventories2 != null){
            for(Inventory i:inventories2){
                if(i.getThreshold()>75) System.out.println(i.getInventoryId()+ " Critical Filling");
                else if(i.getThreshold()>=50 && i.getThreshold()<=75) System.out.println(i.getInventoryId()+ " Moderate Filling");
                else System.out.println(i.getInventoryId()+ " Non-Critical Filling");
            }
        }
        sc.close();
    }
    public static Inventory[] Replenish(Inventory[] inventories, int limit){
        return Arrays.stream(inventories).filter(i -> i.getThreshold()<=limit).toArray(Inventory[]::new);
    }
}
