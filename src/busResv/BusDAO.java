package busResv;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * BusDAO (Data Access Object) class - Handles database operations for Bus entity
 * This class contains methods to retrieve bus information from the database
 */
public class BusDAO {
    /**
     * Method to display all bus information from database
     * Fetches and prints details of all buses including bus number, AC status, and capacity
     * @throws SQLException if database operation fails
     */
    public void displayBusinfo() throws SQLException{
        // SQL query to select all columns from bus table
        String query = "Select * from bus";
        // Get database connection
        Connection con = DbConnection.getConnection();
        // Create statement object to execute SQL queries
        Statement st = con.createStatement();
        // Execute the query and get result set
        ResultSet rs = st.executeQuery(query);

        // Loop through all records in the result set
        while (rs.next()){
            // Print bus number (1st column from database)
            System.out.println("Bus No: " +rs.getInt(1));
            // Check AC status (2nd column) and display user-friendly text
            if (rs.getInt(2) == 0){
                System.out.println("AC: No"); // 0 means no AC
            } else {
                System.out.println("AC: Yes"); // 1 means AC available
            }
            // Print bus capacity (3rd column)
            System.out.println("Capacity: " + rs.getInt(3));
            // Print separator line for better readability
            System.out.println("-----------------------------");

        }
    }

    /**
     * Method to get the capacity of a specific bus
     * @param id - Bus ID to search for
     * @return capacity - The maximum passenger capacity of the specified bus
     * @throws SQLException if database operation fails or bus not found
     */
    public int getCapacity(int id) throws SQLException{
        // SQL query to get capacity for specific bus ID
        String query = "Select capacity from bus where id ="+id;
        // Get database connection
        Connection con = DbConnection.getConnection();
        // Create statement object
        Statement st = con.createStatement();
        // Execute query and get result
        ResultSet rs = st.executeQuery(query);
        // Move to first record (assuming bus ID exists)
        rs.next();
        // Return the capacity value from first column
        return rs.getInt(1);
    }
}
