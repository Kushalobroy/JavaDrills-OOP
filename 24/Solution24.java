import java.util.*;
class Flowers{
    private int flowerId;
    private String flowerName;
    private int price;
    private int rating;
    private String type;
    public Flowers(int flowerId, String flowerName, int price, int rating, String type){
        this.flowerId = flowerId;
        this.flowerName = flowerName;
        this.price = price;
        this.rating = rating;
        this.type = type;
    }
    public String getType(){return type;}
    public int getPrice(){return price;}
    public int getFlowerId(){return flowerId;}
}
public class Solution24 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Flowers[] flowers = new Flowers[4];
        for(int i=0;i<4;i++){
            int flowerId = sc.nextInt();
            sc.nextLine();
            String flowerName = sc.nextLine();
            int price = sc.nextInt();
            sc.nextLine();
            int rating = sc.nextInt();
            sc.nextLine();
            String type = sc.nextLine();
            flowers[i] = new Flowers(flowerId, flowerName, price, rating, type);
        }
        String t = sc.nextLine();
        sc.close();
        Flowers[] flowers2 = findMinPriceByType(flowers, t);
        if(flowers2 != null){
            for(Flowers f:flowers2) System.out.println(f.getFlowerId());
        }
        else System.out.println("There is no flower with given type");
    }
    public static Flowers[] findMinPriceByType(Flowers[] flowers, String type){
        Flowers[] fF = Arrays.stream(flowers).filter(f -> f.getType().equalsIgnoreCase(type)).toArray(Flowers[]::new);
        if(fF.length == 0) return null;
        Arrays.sort(fF, (f1,f2) -> Integer.compare(f1.getPrice(), f2.getPrice()));
        int min = fF[0].getPrice();
        return Arrays.stream(fF).filter(f -> f.getPrice() == min).toArray(Flowers[]::new);
    }
}