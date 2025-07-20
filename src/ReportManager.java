import java.sql.*;
import java.util.Scanner;

public class ReportManager {

    public static void submitReport() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Location: ");
        String location = sc.nextLine();
        System.out.print("Enter Description of Issue: ");
        String description = sc.nextLine();

        String sql = "INSERT INTO citizen_reports (name, location, description, report_date) VALUES (?, ?, ?, CURDATE())";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, location);
            ps.setString(3, description);
            ps.executeUpdate();
            System.out.println("✅ Report submitted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewReports() {
        String sql = "SELECT * FROM citizen_reports";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n📣 Citizen Reports:");
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name") +
                        ", Location: " + rs.getString("location") +
                        ", Description: " + rs.getString("description") +
                        ", Date: " + rs.getDate("report_date"));
                System.out.println("------------------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
