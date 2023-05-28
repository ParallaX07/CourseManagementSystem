public class Teacher extends User{

    public Teacher(String email, String password, String name, String teacherID) {
        super(email, password, name, teacherID);
    }

	
	@Override
    public void handleActions() {
        while (true) {
            System.out.println("1: View Courses     2: Logout");
            System.out.print("> ");
            
            Session session = Session.getSession();
            int choice = session.readUserChoice();
    
            switch (choice) {
                case 1:
                    CourseManagement.viewCourses(getEnrolledCourses());
                    boolean backToMenu = false;
                    do {
                        System.out.print("> "); // Takes index to display list of students
                        int courseIndex = session.readUserChoice() - 1;
                        if (courseIndex < 0 || courseIndex >= getEnrolledCourses().size()) {
                            System.out.println("Invalid course index. Please try again.");
                            break;
                        }
                        Course selectedCourse = getEnrolledCourses().get(courseIndex);
    
                        selectedCourse.viewStudentList();
                        int back = 1;
                        do {
                            System.out.println("1: Remove Student   2: Back");
                            System.out.print(">");
                            int choice2 = session.readUserChoice();
                            switch(choice2){
                                case 1: //Removes student from a course
                                    System.out.print("Index of Student to be removed: ");
                                    int studentIndex = session.readUserChoice() - 1;
                                    if (studentIndex < 0 || studentIndex >= selectedCourse.getStudents().size()) {
                                        System.out.println("Invalid student index. Please try again.");
                                        selectedCourse.viewStudentList();
                                        continue;
                                    }
                                    Student selectedStudent = selectedCourse.getStudents().get(studentIndex);
                                    selectedCourse.removeStudent(selectedStudent);
                                    System.out.println("Student " + selectedStudent.getName() + " removed from " + selectedCourse.getCourseName() + "." + selectedCourse.getSection() + " successfully.");
                                    System.out.println("Press 0 to go back.");
                                    System.out.print("> ");
                                    int choice3 = session.readUserChoice();
                                    if (choice3 == 0) back = 0;
                                    else System.out.println("Invalid choice. Please try again.");
                                case 2:
                                    back = 0;
                                    backToMenu = true;
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                                    selectedCourse.viewStudentList();
                                    break;
                            }
                        } while(back!= 0);
                    } while (!backToMenu);
                    break;
                case 2:
                    return;  // logout
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }   
}