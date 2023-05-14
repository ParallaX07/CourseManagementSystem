import java.util.ArrayList;

public class TA extends User{
    private String assistantID;
    private ArrayList<Course> assignedCourses;

    public TA(String email, String password, String name, String assistantID) {
        super(email, password, name);
        this.assistantID = assistantID;
        this.assignedCourses = new ArrayList<>();
    }

    // Add a course to the TA's assigned courses
    public void addCourse(Course course) {
        this.assignedCourses.add(course);
    }

    // Remove a course from the TA's assigned courses
    public void removeCourse(Course course) {
        this.assignedCourses.remove(course);
    }

    // Get a list of the TA's assigned courses
    public ArrayList<Course> getAssignedCourses() {
        return this.assignedCourses;
    }

    // other methods specific to teaching assistants
	
	@Override
    public boolean handleActions() {
        while (true) {
            System.out.println("1: View Courses\n2: Back");
            System.out.print("> ");
            Session session = Session.getSession();
            int choice = session.inputScanner.nextInt();
            session.inputScanner.nextLine();  // clear the newline left by nextInt()

            switch (choice) {
                case 1:
                    viewCourses();
                    break;
                case 2:
                    return true;  // logout
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    @Override
    public void viewCourses() {
        // Display assigned courses
        for (int i = 0; i < assignedCourses.size(); i++) {
            System.out.println((i + 1) + ": " + assignedCourses.get(i).getCourseName());
        }
    }


    public String getAssistantID() {
        return this.assistantID;
    }

}
