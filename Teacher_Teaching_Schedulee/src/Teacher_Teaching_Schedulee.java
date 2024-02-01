import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Teacher_Teaching_Schedulee {

    public static void main(String[] args) {
        TeacherScheduler teacherScheduler = new TeacherScheduler();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            teacherScheduler.displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Teacher Name: ");
                    String teacherName = scanner.nextLine();
                    teacherScheduler.addTeacher(teacherName);
                    break;
                case 2:
                    System.out.print("Enter Subject Name: ");
                    String subjectName = scanner.nextLine();
                    teacherScheduler.addSubject(subjectName);
                    break;
                case 3:
                    System.out.print("Enter Teacher Name: ");
                    String teacherForAssignment = scanner.nextLine();
                    System.out.print("Enter Subject Name: ");
                    String subjectForAssignment = scanner.nextLine();
                    teacherScheduler.assignSubjectToTeacher(teacherForAssignment, subjectForAssignment);
                    break;
                case 4:
                    System.out.print("Enter Teacher Name: ");
                    String teacherForAvailability = scanner.nextLine();
                    System.out.print("Enter Availability (e.g., Monday 9AM-12PM): ");
                    String availability = scanner.nextLine();
                    teacherScheduler.setTeacherAvailability(teacherForAvailability, availability);
                    break;
                case 5:
                    teacherScheduler.generateSchedule();
                    break;
                case 6:
                    teacherScheduler.viewSchedule();
                    break;
                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 7);

        scanner.close();
    }
}


