public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeTrackerService service = new StudentGradeTrackerService();
        
        while (true) {
            System.out.println("\nStudent Grade Tracker");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grades");
            System.out.println("3. View Student Details");
            System.out.println("4. Generate Performance Report");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                    // Add student logic
                    break;
                case 2:
                    // Add grades logic
                    break;
                case 3:
                    // View student logic
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    service.generatePerformanceReport(studentId);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}