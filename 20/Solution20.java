import java.util.*;
class Hotel{
    private int hotelId;
    private String hotelName;
    private String dateOfBooking;
    private int noOfRoomsBooked;
    private String wifiFacility;
    private double totalBill;
    public Hotel(int hotelId, String hotelName, String dateOfBooking, int noOfRoomsBooked, String wifiFacility, double totalBill){
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.dateOfBooking = dateOfBooking;
        this.noOfRoomsBooked = noOfRoomsBooked;
        this.wifiFacility = wifiFacility;
        this.totalBill = totalBill;
    }
    public String getDate(){return dateOfBooking;}
    public int getNoOfRoomsBooked(){return noOfRoomsBooked;}
    public int getHotelId(){return hotelId;}
    public String getWifiFacility(){return wifiFacility;}
    public double getTotalBill(){return totalBill;}
}
public class Solution20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel[] hotels = new Hotel[4];
        for(int i=0;i<4;i++){
            int hotelId = sc.nextInt();
            sc.nextLine();
            String hotelName = sc.nextLine();
            String dateOfBooking = sc.nextLine();
            int noOfRoomsBooked = sc.nextInt();
            sc.nextLine();
            String wifiFacility = sc.nextLine();
            double totalBill = sc.nextDouble();
            sc.nextLine();
            hotels[i] = new Hotel(hotelId, hotelName, dateOfBooking, noOfRoomsBooked, wifiFacility, totalBill);
        }
        String month = sc.nextLine();
        String wifi = sc.nextLine();
        sc.close();
        int count = noOfRoomsBookedInGivenMonth(hotels, month);
        if(count>0) System.out.println(count);
        else System.out.println("No rooms booked in the given month");
        Hotel[] hotels2 = searchHotelByWifiOption(hotels, wifi);
        if(hotels2 != null){
            for(Hotel h:hotels2){
                System.out.println(h.getHotelId());
            }
        }
        else System.out.println("No such options available");
    }
    public static Hotel[] searchHotelByWifiOption(Hotel[] hotels, String wifi){
        Hotel[] fH = Arrays.stream(hotels).filter(h -> h.getWifiFacility().equalsIgnoreCase(wifi)).toArray(Hotel[]::new);
        if(fH.length < 2) return null;
        Arrays.sort(fH,(h1, h2)->Double.compare(h2.getTotalBill(), h1.getTotalBill()));
        double sH = fH[1].getTotalBill();
        Hotel[] rs = Arrays.stream(fH).filter(h -> h.getTotalBill() == sH).toArray(Hotel[]::new);
        if(rs == null) return null;
        return rs;
    }
    public static int noOfRoomsBookedInGivenMonth(Hotel[] hotels, String month){
        int count=0;
        Hotel[] fH = Arrays.stream(hotels).filter(h -> h.getDate().split("-")[1].equalsIgnoreCase(month)).toArray(Hotel[]::new);
        if(fH.length ==0 ) return 0;
        for(Hotel h : fH) {
            count+=h.getNoOfRoomsBooked();
        }
        return count;

    }
}
