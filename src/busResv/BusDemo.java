package busResv;
import java.util.Scanner;

public class BusDemo {
    public static void main(String[] args){

        BusDAO busdao = new BusDAO();

        try{
            busdao.displayBusinfo ();

            int userOpt =1;
            Scanner scanner=new Scanner(System.in);

            while(userOpt==1){
                System.out.println("Enter 1 to book, and Enter 2 to exit");
                userOpt=scanner.nextInt();

                if (userOpt == 1) {
                    Booking booking = new Booking(); //Booking is constructor so automatically it will call the constructor
                    //booking object is created and constructor is called
                    if(booking.isAvailable()){
                        //BookingDAO bookingdao = new BookingDAO(); //hide because it is already called in Booking class
                        //bookingdao.addBooking(booking);
                        System.out.println("Booking is confirmed");
                    }
                    else {
                        System.out.println("Booking is not available");
                    }
                }

            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
