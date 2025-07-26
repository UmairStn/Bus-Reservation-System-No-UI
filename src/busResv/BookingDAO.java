package busResv;

import java.sql.*;

/**
 * BookingDAO (Data Access Object) class - Handles database operations for Booking entity
 * This class manages booking-related database operations like checking availability and adding bookings
 */
public class BookingDAO {
    /**
     * Method to count how many seats are already booked for a specific bus on a specific date
     * @param busNo - Bus number to check bookings for
     * @param date - Travel date to check bookings for
     * @return count - Number of passengers already booked for this bus on this date
     * @throws SQLException if database operation fails
     */
    public int getBookedCount(int busNo, Date date) throws SQLException {
        // SQL query with placeholders (?) to prevent SQL injection attacks
        String query = "select count(passenger_name) from booking where bus_no = ? and travel_date = ?";
        // Get database connection
        Connection con = DbConnection.getConnection();
        // Create prepared statement for secure parameter binding
        PreparedStatement pst = con.prepareStatement(query);
        // Convert java.util.Date to java.sql.Date for database compatibility
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        // Set first parameter (bus number) in the query
        pst.setInt(1, busNo); //in here value are sending in directly
        // Set second parameter (travel date) in the query
        pst.setDate(2, sqldate);
        // Execute the query and get result set
        ResultSet rs = pst.executeQuery();
        // Move to first (and only) record
        rs.next();
        // Return the count from first column
        return rs.getInt(1); // Replace with actual database logic

    }

    /**
     * Method to add a new booking record to the database
     * @param booking - Booking object containing passenger name, bus number, and travel date
     * @throws SQLException if database insert operation fails
     */
    public void addBooking(Booking booking) throws SQLException {
        // SQL insert query with placeholders for values
        String query = "insert into booking values (?, ?, ?)";
        // Get database connection
        Connection con = DbConnection.getConnection();

        // Create prepared statement for secure parameter binding
        PreparedStatement pst = con.prepareStatement(query);
        // Set passenger name from booking object (1st column)
        pst.setString(1, booking.passengerName); //in here value are sending in object
        // Set bus number from booking object (2nd column)
        pst.setInt(2, booking.busNo);
        // Convert date format for database storage
        java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
        // Set travel date (3rd column)
        pst.setDate(3, sqldate);
        // Execute the insert operation (no result set returned)
        pst.executeUpdate();
    }
}
