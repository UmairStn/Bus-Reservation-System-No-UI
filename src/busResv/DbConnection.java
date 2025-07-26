package busResv;

import java.sql.*;

/**
 * DbConnection class - Handles database connectivity
 * This class provides centralized database connection configuration
 */
public class DbConnection {
    // Database connection URL - points to MySQL server on localhost with database 'busresv'
    private static String url = "jdbc:mysql://localhost:3306/busresv";
    // Database username for authentication
    private static String user = "root";
    // Database password for authentication
    private static String password = "Umair.123";

    /**
     * Static method to get database connection
     * This method establishes and returns a connection to the MySQL database
     * @return Connection object for database operations
     * @throws SQLException if connection fails
     */
    public static Connection getConnection() throws SQLException {
        // Use DriverManager to create connection with provided credentials
        return DriverManager.getConnection(url, user, password);
    }
}
