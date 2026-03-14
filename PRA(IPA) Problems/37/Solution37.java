import java.util.*;
class Newspaper{
    private int regNo;
    private String name;
    private int publicationYear;
    private int price;
    public Newspaper(int regNo, String name, int publicationYear, int price) {
        this.regNo = regNo;
        this.name = name;
        this.publicationYear = publicationYear;
        this.price = price;
    }
    public int getRegNo(){return regNo;}
    public String getName(){return name;}
    public int getPublicationYear(){return publicationYear;}
    public int getPrice(){return price;}
}
public class Solution37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Newspaper[] newspapers = new Newspaper[4];
        for(int i=0;i<4;i++){
            int regNo = sc.nextInt(); sc.nextLine();
            String name = sc.nextLine();
            int publicationYear = sc.nextInt(); sc.nextLine();
            int price = sc.nextInt(); sc.nextLine();
            newspapers[i] = new Newspaper(regNo, name, publicationYear, price);
        }
        int pubYear = sc.nextInt(); sc.nextLine();
        String name = sc.nextLine();
        int totalPrice = findTotalPriceByPublicationYear(newspapers, pubYear);
        if(totalPrice>0) System.out.println(totalPrice);
        else System.out.println("No Newspaper found with the mentioned attribute");

        Newspaper[] newspapers2 = searchNewspaperByName(newspapers, name);
        if(newspapers2 != null){
            for(Newspaper n:newspapers2){
                System.out.println("regNo-"+n.getRegNo());
                System.out.println("name-"+n.getName());
                System.out.println("publicationYear-"+n.getPublicationYear());
                System.out.println("price-"+n.getPrice());
            }
        }
        else System.out.println("No Newspaper found with the given name");
        sc.close();
    }
    public static Newspaper[] searchNewspaperByName(Newspaper[] n, String name){
        Newspaper[] fN = Arrays.stream(n).filter(a -> a.getName().equalsIgnoreCase(name)).toArray(Newspaper[]::new);
        if(fN.length == 0) return null;
        return fN;
    }
    public static int findTotalPriceByPublicationYear(Newspaper[] newspapers, int pubYear){
        
        Newspaper[] fN = Arrays.stream(newspapers).filter(n -> n.getPublicationYear() == pubYear).toArray(Newspaper[]::new);
        if(fN.length == 0) return 0;
        int totalPrice = 0;
        for(Newspaper n: fN) totalPrice+=n.getPrice();
        return totalPrice;
    }
}
