package busResv;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.lang.Throwable;

public class Booking {
    String passengerName;
    int busNo;
    Date date;

    Scanner scanner = new Scanner(System.in);

    Booking(){
        System.out.println("Enter Passenger Name: ");
        passengerName = scanner.next();
        System.out.println("Enter BusNo: ");
        busNo = scanner.nextInt();
        System.out.println("Enter Date(dd-mm-yyyy): ");
        String dateInput = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean isAvailable() throws SQLException {

        BusDAO busdao = new BusDAO();
        BookingDAO bookingdao = new BookingDAO();
        int capacity = busdao.getCapacity(busNo);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        int bookedCount = bookingdao.getBookedCount(busNo, sqlDate);



        if (bookedCount >= capacity) {
            System.out.println("no seats available");
            return false;
        } else {
            // Proceed with booking
            int booked = bookingdao.getBookedCount(busNo,sqlDate);
            bookingdao.addBooking(this);
            System.out.println("Booking confirmed");
            return true;
        }
    }

}
