package busResv;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Booking class - Represents a bus booking with passenger information
 * This class handles booking creation, user input collection, and availability checking
 */
public class Booking {
    // Booking details (package-private for DAO access)
    String passengerName; // Name of the passenger making the booking
    int busNo;           // Bus number for the booking
    Date date;           // Travel date for the booking

    // Scanner object for reading user input from console
    Scanner scanner = new Scanner(System.in);

    /**
     * Constructor - Automatically collects booking information from user
     * Prompts user to enter passenger name, bus number, and travel date
     */
    Booking(){
        // Prompt and read passenger name
        System.out.println("Enter Passenger Name: ");
        passengerName = scanner.next();
        
        // Prompt and read bus number
        System.out.println("Enter BusNo: ");
        busNo = scanner.nextInt();
        
        // Prompt and read travel date
        System.out.println("Enter Date(dd-mm-yyyy): ");
        String dateInput = scanner.next();
        // Define expected date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // Parse the string input into Date object
        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            // Print error if date format is invalid
            e.printStackTrace();
        }
    }

    /**
     * Method to check seat availability and process booking
     * This method both checks availability AND saves the booking if seats are available
     * @return true if booking is successful, false if no seats available
     * @throws SQLException if database operations fail
     */
    public boolean isAvailable() throws SQLException {

        // Create DAO objects for database operations
        BusDAO busdao = new BusDAO();        // For bus-related operations
        BookingDAO bookingdao = new BookingDAO(); // For booking-related operations
        
        // Get total capacity of the requested bus
        int capacity = busdao.getCapacity(busNo);
        // Convert date for database query
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        // Get current number of bookings for this bus on this date
        int bookedCount = bookingdao.getBookedCount(busNo, sqlDate);

        // Check if bus is fully booked
        if (bookedCount >= capacity) {
            // No seats available - inform user and return false
            System.out.println("no seats available");
            return false;
        } else {
            // Seats are available - proceed with booking
            // Re-check booking count (redundant but kept as is)
            int booked = bookingdao.getBookedCount(busNo,sqlDate);
            // Add this booking to the database
            bookingdao.addBooking(this);
            // Confirm booking to user
            System.out.println("Booking confirmed");
            return true; // Return true indicating successful booking
        }
    }

}
