import java.util.*;
class Medicine{
    private String MedicineName;
    private String batch;
    private String disease;
    private int price;
    public Medicine(String MedicineName, String batch, String disease, int price) {
        this.MedicineName = MedicineName;
        this.batch = batch;
        this.disease = disease;
        this.price = price;
    }
    public int getPrice(){return price;}
    public String getDisease(){return disease;}
}
public class Solution10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Medicine[] medicines = new Medicine[4];
        for(int i=0;i<4;i++){
            String MedicineName = sc.nextLine();
            String batch = sc.nextLine();
            String disease = sc.nextLine();
            int price = sc.nextInt();
            sc.nextLine();
            medicines[i] = new Medicine(MedicineName, batch, disease, price);
        }
        String dis = sc.nextLine();
        Medicine[] medicines2 = getPriceByDisease(medicines, dis);
        for(Medicine m:medicines2){
            System.out.println(m.getPrice());
        }
    }
    public static Medicine[] getPriceByDisease(Medicine[] medicines, String disease){
        Medicine[] filteredMedicines = Arrays.stream(medicines).filter(m -> m.getDisease().equalsIgnoreCase(disease)).toArray(Medicine[]::new);
        Arrays.sort(filteredMedicines,(m1,m2)-> Integer.compare(m1.getPrice(), m2.getPrice()));
        return filteredMedicines;
    }
}
