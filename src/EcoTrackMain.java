import java.util.Scanner;

public class EcoTrackMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=======  EcoTrack Main Menu =======");
            System.out.println("1. Add Monitoring Station");
            System.out.println("2. View Stations");
            System.out.println("3. Insert Environmental Data");
            System.out.println("4. View Environmental Data");
            System.out.println("5. Submit Citizen Report");
            System.out.println("6. View Citizen Reports");
            System.out.println("0. Exit");
            System.out.print(" Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> StationManager.addStation();
                case 2 -> StationManager.viewStations();
                case 3 -> DataManager.insertData();
                case 4 -> DataManager.viewData();
                case 5 -> ReportManager.submitReport();
                case 6 -> ReportManager.viewReports();
                case 0 -> System.out.println(" Exiting EcoTrack...");
                default -> System.out.println(" Invalid choice. Try again.");
            }
        } while (choice != 0);
    }
}
