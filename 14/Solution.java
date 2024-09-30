import java.util.*;
class Footwear {
    private int footwearId;
    private String footwearName;
    private String footwearType;
    private int price;
    
    public Footwear(int footwearId, String footwearName, String footwearType, int price) {
        this.footwearId = footwearId;
        this.footwearName = footwearName;
        this.footwearType = footwearType;
        this.price = price;
    }
    
    public String getFootwearType(){ return footwearType; }
    public int getFootwearId(){ return footwearId; }
    public String getFootwearName(){ return footwearName; }
    public int getPrice(){ return price; }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Footwear[] footwears = new Footwear[4];
        
        for(int i = 0; i < 4; i++){
            int footwearId = sc.nextInt();
            sc.nextLine();
            String footwearName = sc.nextLine();
            String footwearType = sc.nextLine();
            int price = sc.nextInt();
            sc.nextLine();
            footwears[i] = new Footwear(footwearId, footwearName, footwearType, price);
        }
        
        String type = sc.nextLine();
        String inputFootwearName = sc.nextLine();
        
        int count = getCountType(footwears, type);
        if(count > 0) 
            System.out.println(count);
        else 
            System.out.println("Footwear not available");

        Footwear[] secondFootwear = getSecondHighestPriceByBrand(footwears, inputFootwearName);
        
        if(secondFootwear != null && secondFootwear.length > 0) {
            for(Footwear f : secondFootwear){
                System.out.println(f.getFootwearId());
                System.out.println(f.getFootwearName());
                System.out.println(f.getPrice());
            }
        } else {
            System.out.println("Brand not available or not enough items to find the second highest price.");
        }
        sc.close();
    }

    public static Footwear[] getSecondHighestPriceByBrand(Footwear[] footwears, String name) {
        // Filter by brand name (case-insensitive)
        Footwear[] filteredFootwears = Arrays.stream(footwears)
                .filter(f -> f.getFootwearName().equalsIgnoreCase(name))
                .toArray(Footwear[]::new);
        
        // Check if there are at least 2 footwear items after filtering
        if(filteredFootwears.length < 2) {
            return null; // Not enough items to get the second highest
        }
        
        // Sort by price in descending order
        Arrays.sort(filteredFootwears, (f1, f2) -> Integer.compare(f2.getPrice(), f1.getPrice()));
        
        // Get the second highest price
        int secondHighestPrice = filteredFootwears[1].getPrice();
        
        // Filter again to return footwears with the second highest price
        Footwear[] res = Arrays.stream(filteredFootwears)
                .filter(f -> f.getPrice() == secondHighestPrice)
                .toArray(Footwear[]::new);

        return res;
    }

    public static int getCountType(Footwear[] footwears, String type) {
        Footwear[] filteredFootwears = Arrays.stream(footwears)
                .filter(f -> f.getFootwearType().equalsIgnoreCase(type))
                .toArray(Footwear[]::new);
        
        return filteredFootwears.length;
    }
}
