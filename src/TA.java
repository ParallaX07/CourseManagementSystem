public class TA extends User{

    public TA(String email, String password, String name, String assistantID) {
        super(email, password, name, assistantID);
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
                    CourseManagement.viewCourses(getEnrolledCourses());
                    boolean backToMenu = false;
                    do{
                        System.out.println("Choose an index or Press 0 to go back.");
                        System.out.print("> "); // Takes index to display list of students
                        int courseIndex = session.readUserChoice() - 1;
                        if (courseIndex == -1) backToMenu = true; // go back to menu
                        else if (courseIndex < 0 || courseIndex >= getEnrolledCourses().size()) {
                            System.out.println("Invalid course index. Please try again.");
                            continue;
                        }
                        else {
                            Course selectedCourse = getEnrolledCourses().get(courseIndex);
                            selectedCourse.viewStudentList();
                            System.out.println("Press 0 to go back");
                            int choice2 = session.readUserChoice();
                            if (choice2 == 0) backToMenu = true;
                        }
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
}
