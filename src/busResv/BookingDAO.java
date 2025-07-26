package busResv;

import java.sql.*;

public class BookingDAO {
    public int getBookedCount(int busNo, Date date) throws SQLException {
        String query = "select count(passenger_name) from booking where bus_no = ? and travel_date = ?";
        Connection con = DbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        pst.setInt(1, busNo); //in here value are sending in directly
        pst.setDate(2, sqldate);
        ResultSet rs = pst.executeQuery();
        rs.next();
        return rs.getInt(1); // Replace with actual database logic

    }

    public void addBooking(Booking booking) throws SQLException {
        String query = "insert into booking values (?, ?, ?)";
        Connection con = DbConnection.getConnection();

        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, booking.passengerName); //in here value are sending in object
        pst.setInt(2, booking.busNo);
        java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
        pst.setDate(3, sqldate);
        pst.executeUpdate();
    }
}
