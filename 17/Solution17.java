import java.util.*;
class Motel{
    private int motelId;
    private String motelName;
    private String dateOfBooking;
    private int noOfRoomsBooked;
    private String cabFacility;
    private double totalBil;
    public Motel(int motelId, String motelName, String dateOfBooking, int noOfRoomsBooked, String cabFacility, double totalBil){
        this.motelId = motelId;
        this.motelName = motelName;
        this.dateOfBooking = dateOfBooking;
        this.noOfRoomsBooked = noOfRoomsBooked;
        this.cabFacility = cabFacility;
        this.totalBil = totalBil;
    }
    public String getCabFacility(){return cabFacility;}
    public int getNoOfRoomsBooked(){return noOfRoomsBooked;}
}
public class Solution17{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Motel[] motels = new Motel[4];
        for(int i=0;i<4;i++){
            int motelId = sc.nextInt();
            sc.nextLine();
            String motelName = sc.nextLine();
            String dateOfBooking = sc.nextLine();
            int noOfRoomsBooked = sc.nextInt();
            sc.nextLine();
            String cabFacility = sc.nextLine();
            double totalBil = sc.nextDouble();
            sc.nextLine();
            motels[i] = new Motel(motelId,motelName,dateOfBooking,noOfRoomsBooked, cabFacility, totalBil);
        }
        String cab = sc.nextLine();
        int count = totalNoOfRoomsBooked(motels, cab);
        if(count>0) System.out.println(count);
        else System.out.println("No such rooms booked");
        sc.close();
    }
    public static int totalNoOfRoomsBooked(Motel[] motels, String cab){
        int count = 0;
        Motel[] fM = Arrays.stream(motels).filter(m -> m.getCabFacility().equalsIgnoreCase(cab) && m.getNoOfRoomsBooked()>5).toArray(Motel[]::new);
        for(Motel m:fM){
            count += m.getNoOfRoomsBooked();
        }
        return count;
    }
}