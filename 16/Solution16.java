import java.util.*;
class College{
    private int id;
    private String name;
    private int contactNo;
    private String address;
    private int pinCode;
    public College(int id, String name, int contactNo, String address, int pinCode){
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
        this.pinCode = pinCode;
    }
    public int getId(){return id;}
    public String getName(){return name;}
    public int getContactNo(){return contactNo;}
    public String getAddress(){return address;}
    public int getPinCode(){return pinCode;}

}
public class Solution16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        College[] colleges = new College[4];
        for(int i=0;i<4;i++){
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            int contactNo = sc.nextInt();
            sc.nextLine();
            String address = sc.nextLine();
            int pinCode = sc.nextInt();
            sc.nextLine();
            colleges[i] = new College(id, name, contactNo, address, pinCode);
        }
        String addressInput = sc.nextLine();
        sc.close();

        College[] maxPincode = findCollegeWithMaximumPincode(colleges);
        if(maxPincode != null){
            for(College c:maxPincode){
                System.out.println("id-"+c.getId());
                System.out.println("name-"+c.getName());
                System.out.println("contactNo-"+c.getContactNo());
                System.out.println("address-"+c.getAddress());
                System.out.println("pincode-"+c.getPinCode());
            }
        }
        else System.out.println("No college found with mentioned attribute");

        College[] colleges2 = searchCollegeByAddress(colleges, addressInput);
        if(colleges2 != null){
            for(College c:colleges2){
                System.out.println("id-"+c.getId());
                System.out.println("name-"+c.getName());
                System.out.println("contactNo-"+c.getContactNo());
                System.out.println("address-"+c.getAddress());
                System.out.println("pincode-"+c.getPinCode());
            }
        }
        else System.out.println("No college found with mentioned attribute");
    }
    public static College[] searchCollegeByAddress(College[] colleges, String address){
        College[] fC = Arrays.stream(colleges).filter(c ->c.getAddress().equalsIgnoreCase(address)).toArray(College[]::new);
        if(fC == null) return null;
        return fC;
    }
    public static College[] findCollegeWithMaximumPincode(College[] colleges){
        Arrays.sort(colleges, (c1,c2) -> Integer.compare(c2.getPinCode(), c1.getPinCode()));
        int hP = colleges[0].getPinCode();
        College[] fC = Arrays.stream(colleges).filter(c -> c.getPinCode() == hP).toArray(College[]::new);
        if(fC == null) return null;
        return fC;
    }
}
