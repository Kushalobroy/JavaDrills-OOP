import java.util.*;

class Vegetable{
    private int VegetableId;
    private String VegetableName;
    private int Price;
    private int Rating;
    public Vegetable(int VegetableId, String VegetableName, int Price, int Rating){
        this.VegetableId = VegetableId;
        this.VegetableName = VegetableName;
        this.Price = Price;
        this.Rating = Rating;
    }
    public int getId(){return VegetableId;}
    public String getName(){return VegetableName;}
    public int getPrice(){return Price;}
    public int getRating(){return Rating;}
}
public class Solution43 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Vegetable[] vegetables = new Vegetable[4];
        for(int i=0;i<4;i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt(); sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            vegetables[i] = new Vegetable(a,b,c,d);
        }
        int rating = sc.nextInt(); sc.nextLine();
        Vegetable[] v2 = findMinimumPriceByRating(vegetables, rating);
        if(v2 != null){
            for(Vegetable i:v2) System.out.println(i.getId());
        }
        else System.out.println("No such Vegetables");
        sc.close();
    }
    public static Vegetable[] findMinimumPriceByRating(Vegetable[] vegetables, int rating){
        Vegetable[] fV = Arrays.stream(vegetables).filter(i -> i.getRating()>rating).toArray(Vegetable[]::new);
        if(fV.length == 0) return null;
        Arrays.sort(fV, (i1, i2)->Integer.compare(i1.getPrice(), i2.getPrice()));
        int min = fV[0].getPrice();
        Vegetable[] res = Arrays.stream(fV).filter(i -> i.getPrice() == min).toArray(Vegetable[]::new);
        return res;
    }
}
