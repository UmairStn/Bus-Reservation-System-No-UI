package busResv;
import java.util.Scanner;

/**
 * BusDemo class - Main entry point of the Bus Reservation System
 * This class handles the user interface and main application flow
 */
public class BusDemo {
    /**
     * Main method - Starting point of the application
     * @param args - Command line arguments
     */
    public static void main(String[] args){

        // Create BusDAO object to handle bus-related database operations
        BusDAO busdao = new BusDAO();

        try{
            // Display all available buses with their information (Bus No, AC, Capacity)
            busdao.displayBusinfo ();

            // Initialize user option to 1 to enter the booking loop
            int userOpt =1;
            // Scanner object to read user input from console
            Scanner scanner=new Scanner(System.in);

            // Main application loop - continues until user chooses to exit (option 2)
            while(userOpt==1){
                // Display menu options to user
                System.out.println("Enter 1 to book, and Enter 2 to exit");
                userOpt=scanner.nextInt(); // Read user's choice

                // If user chooses option 1 (book a ticket)
                if (userOpt == 1) {
                    // Create new Booking object - constructor will automatically prompt for passenger details
                    Booking booking = new Booking(); //Booking is constructor so automatically it will call the constructor
                    //booking object is created and constructor is called
                    
                    // Check if seats are available for the requested booking
                    if(booking.isAvailable()){
                        //BookingDAO bookingdao = new BookingDAO(); //hide because it is already called in Booking class
                        //bookingdao.addBooking(booking); // This is commented out because booking is already saved in isAvailable() method
                        System.out.println("Booking is confirmed"); // Additional confirmation message
                    }
                    else {
                        // If no seats available, inform the user
                        System.out.println("Booking is not available");
                    }
                }
                // If user enters 2, the while loop will exit and program will terminate

            }
            // Close scanner to free up system resources
            scanner.close();
        } catch (Exception e) {
            // Catch and print any exceptions that occur during execution
            System.out.println(e);
        }
    }
}
