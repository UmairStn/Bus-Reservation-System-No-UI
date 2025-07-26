package busResv;

import java.sql.*;

public class DbConnection {
    private static String url = "jdbc:mysql://localhost:3306/busresv";
    private static String user = "root";
    private static String password = "Umair.123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
