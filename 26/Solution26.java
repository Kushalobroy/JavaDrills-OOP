import java.util.*;
class Fruits{
    private int fruitId;
    private String fruitName;
    private int price;
    private int rating;
    public Fruits(int fruitId, String fruitName, int price, int rating){
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.rating = rating;
    }
    int getPrice(){return price;}
    int getRating(){return rating;}
    int getFruitId(){return fruitId;}
}
public class Solution26{
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);
        Fruits[] fruits = new Fruits[4];
        for(int i=0;i<4;i++){
            int fruitId = sc.nextInt();
            sc.nextLine();
            String fruitName = sc.nextLine();
            int price = sc.nextInt();
            sc.nextLine();
            int rating = sc.nextInt();
            sc.nextLine();
            fruits[i] = new Fruits(fruitId, fruitName, price, rating);
        }  
        int ratings  = sc.nextInt();
        sc.close();
        Fruits[] fruits2 = findMaximumPriceByRating(fruits, ratings);
        if(fruits2 != null){
            for(Fruits f:fruits2){
                System.out.println(f.getFruitId());
            }
        }
        else System.out.println("No such Fruits");
    }
    public static Fruits[] findMaximumPriceByRating(Fruits[] fruits, int rating){
        Fruits[] fF = Arrays.stream(fruits).filter(f -> f.getRating()>rating).toArray(Fruits[]::new);
        if(fF.length == 0) return null;
        Arrays.sort(fF, (f1, f2) -> Integer.compare(f2.getPrice(), f1.getPrice()));
        int max = fF[0].getPrice();
        return Arrays.stream(fF).filter(f1 -> f1.getPrice() == max).toArray(Fruits[]::new);
    }
}