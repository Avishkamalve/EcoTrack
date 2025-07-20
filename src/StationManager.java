import java.sql.*;
import java.util.Scanner;

public class StationManager {

    public static void addStation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter station name: ");
        String name = sc.nextLine();
        System.out.print("Enter station location: ");
        String location = sc.nextLine();

        String sql = "INSERT INTO stations (name, location) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, location);
            ps.executeUpdate();
            System.out.println("✅ Station added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewStations() {
        String sql = "SELECT * FROM stations";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n📍 Monitoring Stations:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("station_id") +
                        ", Name: " + rs.getString("name") +
                        ", Location: " + rs.getString("location"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
