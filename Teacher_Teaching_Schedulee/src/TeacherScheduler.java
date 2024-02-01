import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TeacherScheduler {
    private List<String> teachers;
    private List<String> subjects;
    private Map<String, String> subjectAssignments;
    private Map<String, String> teacherAvailability;
    private Map<String, List<String>> schedule;

    public TeacherScheduler() {
        teachers = new ArrayList<>();
        subjects = new ArrayList<>();
        subjectAssignments = new HashMap<>();
        teacherAvailability = new HashMap<>();
        schedule = new HashMap<>();  // Initialize the schedule map
    }

    public void displayMenu() {
        System.out.println("==== Teacher Scheduler ====");
        System.out.println("1. Add Teacher");
        System.out.println("2. Add Subject");
        System.out.println("3. Assign Subject to Teacher");
        System.out.println("4. Set Teacher Availability");
        System.out.println("5. Generate Schedules");
        System.out.println("6. View Schedules");
        System.out.println("7. Exit");
    }

    public void addTeacher(String teacherName) {
        teachers.add(teacherName);
        System.out.println("Teacher added: " + teacherName);
    }

    public void addSubject(String subjectName) {
        subjects.add(subjectName);
        System.out.println("Subject added: " + subjectName);
    }

    public void assignSubjectToTeacher(String teacherName, String subjectName) {
        if (teachers.contains(teacherName) && subjects.contains(subjectName)) {
            subjectAssignments.put(teacherName, subjectName);
            System.out.println("Subject assigned to teacher: " + subjectName + " -> " + teacherName);
        } else {
            System.out.println("Teacher or subject does not exist. Please add them first.");
        }
    }

    public void setTeacherAvailability(String teacherName, String availability) {
        teacherAvailability.put(teacherName, availability);
        System.out.println("Availability set for " + teacherName + ": " + availability);
    }

    public void generateSchedule() {
        // Basic implementation: Just print the assignments and availability
        for (String teacher : teachers) {
            String assignedSubject = subjectAssignments.getOrDefault(teacher, "No Subject Assigned");
            String availability = teacherAvailability.getOrDefault(teacher, "No Availability Set");
            System.out.println("Teacher: " + teacher + ", Subject: " + assignedSubject + ", Availability: " + availability);
        }
    }

    public void viewSchedule() {
        // Basic implementation: Show the schedule based on assignments and availability
        for (Map.Entry<String, String> entry : subjectAssignments.entrySet()) {
            String teacher = entry.getKey();
            String assignedSubject = entry.getValue();
            String availability = teacherAvailability.getOrDefault(teacher, "No Availability Set");

            List<String> teacherSchedule = schedule.computeIfAbsent(teacher, k -> new ArrayList<>());
            teacherSchedule.add("Subject: " + assignedSubject + ", Availability: " + availability);
        }

        for (Map.Entry<String, List<String>> entry : schedule.entrySet()) {
            String teacher = entry.getKey();
            List<String> teacherSchedule = entry.getValue();

            System.out.println("Teacher: " + teacher);
            for (String scheduleEntry : teacherSchedule) {
                System.out.println("  " + scheduleEntry);
            }
        }
    }
}
