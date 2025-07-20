import java.sql.*;
import java.util.Scanner;

public class DataManager {

    public static void insertData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Station ID: ");
        int stationId = sc.nextInt();
        System.out.print("Enter Temperature (°C): ");
        float temp = sc.nextFloat();
        System.out.print("Enter Humidity (%): ");
        float humidity = sc.nextFloat();
        System.out.print("Enter AQI: ");
        int aqi = sc.nextInt();
        System.out.print("Enter Noise Level (dB): ");
        float noise = sc.nextFloat();

        String sql = "INSERT INTO environment_data (station_id, date_recorded, temperature, humidity, air_quality_index, noise_level) " +
                "VALUES (?, CURDATE(), ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, stationId);
            ps.setFloat(2, temp);
            ps.setFloat(3, humidity);
            ps.setInt(4, aqi);
            ps.setFloat(5, noise);
            ps.executeUpdate();
            System.out.println("✅ Environmental data recorded successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewData() {
        String sql = "SELECT * FROM environment_data";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n📊 Environmental Records:");
            while (rs.next()) {
                System.out.println("Station ID: " + rs.getInt("station_id") +
                        ", Date: " + rs.getDate("date_recorded") +
                        ", Temp: " + rs.getFloat("temperature") + "°C" +
                        ", Humidity: " + rs.getFloat("humidity") + "%" +
                        ", AQI: " + rs.getInt("air_quality_index") +
                        ", Noise: " + rs.getFloat("noise_level") + " dB");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
