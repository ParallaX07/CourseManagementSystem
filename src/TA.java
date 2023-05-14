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

    //Displays students in a particular course
    public void viewStudents(Course course) {
        ArrayList<Student> studentList = course.getStudentList();
        if (this.assignedCourses.contains(course)) {
            if (studentList.isEmpty()) {
                System.out.println("No students enrolled in this course.");
                return;
            }
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println((i + 1) + ". " + "Name: " +studentList.get(i).getName() + ", ID: " + studentList.get(i).getStudentID());
            }
        }
    }
	
	@Override
    public boolean handleActions() {
        while (true) {
            System.out.println("1: View Courses\n2: Back");
            System.out.print("> ");
            Session session = Session.getSession();
            int choice = session.readUserChoice();

            switch (choice) {
                case 1:
                    viewCourses();
                    boolean backToMenu = false;
                    do{
                        System.out.print("> "); // Takes index to display list of students
                        int courseIndex = session.readUserChoice() - 1;
                        if (courseIndex < 0 || courseIndex >= assignedCourses.size()) {
                            System.out.println("Invalid course index. Please try again.");
                            continue;
                        }
                        Course selectedCourse = assignedCourses.get(courseIndex);
                        viewStudents(selectedCourse);
                        System.out.println("Press 0 to go back");
                        int choice2 = session.readUserChoice();
                        if (choice2 == 0) backToMenu = true;
                    }while(!backToMenu);
                    break;
                case 2:
                    return true;  // logout
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public void viewCourses() {
        // Display assigned courses
        if (assignedCourses.isEmpty()) {
            System.out.println("No courses assigned.");
        }
        else{
            for (int i = 0; i < assignedCourses.size(); i++) {
                System.out.println((i + 1) + ": " + assignedCourses.get(i).getCourseName() + "." + assignedCourses.get(i).getSection());
            }
        }
    }

    public String getAssistantID() {
        return this.assistantID;
    }

}
