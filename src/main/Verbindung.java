package main;
import java.sql.*;

public class Verbindung {
    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:/Users/PC/Desktop/SQLite/TauTourDB.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Verbindung wird aufgebaut!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void main(String[] args) {
        Connection conn = connect();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from administrator");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt("id") + " " + rs.getString("vorname") + " " + rs.getString("nachname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
