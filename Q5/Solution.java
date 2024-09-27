import java.util.*;

class Phone{
    private int phoneId;
    private String os;
    private String brand;
    private int price;
    public Phone(int phoneId, String os, String brand, int price){
        this.phoneId = phoneId;
        this.os = os;
        this.brand = brand;
        this.price = price;
    }
    public int getPrice(){return price;}
    public String getBrand(){return brand;}
    public int getPhoneId(){return phoneId;}
    public String getOs(){return os;}
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Phone[] phones = new Phone[4];
        for(int i=0;i<4;i++){
            int phoneId = sc.nextInt();
            sc.nextLine();
            String os = sc.nextLine();
            String brand = sc.nextLine();
            int price = sc.nextInt();
            sc.nextLine();
            phones[i] = new Phone(phoneId, os, brand, price);
        }
        String brands = sc.nextLine();
        String oss = sc.nextLine();
        int priceOfGivenBrand = findPriceForGivenBrand(phones, brands);
        if(priceOfGivenBrand>0) System.out.println(priceOfGivenBrand);
        else System.out.println("The given Brand is not available");
        Phone[] phones2 = getPhoneIdBasedOnOs(phones, oss);
        if(phones2 !=null){
            for(Phone p:phones2) System.out.println(p.getPhoneId());
        }
        else System.out.println("No phones are available with specified os and price range");
    }
    public static Phone[] getPhoneIdBasedOnOs(Phone[] phones, String os){
        Phone[] filteredPhones = Arrays.stream(phones).filter(p -> p.getOs().equalsIgnoreCase(os) && p.getPrice()>=50000).toArray(Phone[]::new);
        if(filteredPhones.length ==0) return null;
        return filteredPhones;
    }
    public static int findPriceForGivenBrand(Phone[] phones, String brands){
        int price = 0;
        Phone[] filteredPhones = Arrays.stream(phones).filter(p -> p.getBrand().equalsIgnoreCase(brands)).toArray(Phone[]::new);
        for(Phone p:filteredPhones){
            price+=p.getPrice();
        }
        return price;
    }
}
