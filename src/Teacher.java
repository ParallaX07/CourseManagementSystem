import java.util.ArrayList;

public class Teacher extends User{
    private String teacherID;
    private ArrayList<Course> assignedCourses;

    public Teacher(String email, String password, String name, String teacherID) {
        super(email, password, name);
        this.teacherID = teacherID;
        this.assignedCourses = new ArrayList<>();
    }

    // Add a course to the teacher's assigned courses
    public void addCourse(Course course) {
        this.assignedCourses.add(course);
    }

    // Remove a student from a specific course
    public void removeStudentFromCourse(Student student, Course course) {
        if (this.assignedCourses.contains(course)) {
            course.removeStudent(student);
        }
    }
	
	@Override
    public boolean handleActions() {
        while (true) {
            System.out.println("1: View Courses\n2: Logout");
            System.out.print("> ");
            
            Session session = Session.getSession();
            int choice = session.inputScanner.nextInt();
            session.inputScanner.nextLine();  // clear the newline left by nextInt()
    
            switch (choice) {
                case 1:
                    if (assignedCourses.isEmpty()) {
                        System.out.println("No courses assigned.");
                        break;
                    }
                    viewCourses();
                    boolean backToMenu = false;
                    do {
                        System.out.print("> "); // Takes index to display list of students
                        int courseIndex = session.inputScanner.nextInt() - 1;
                        session.inputScanner.nextLine();  // clear the newline left by nextInt()
                        if (courseIndex < 0 || courseIndex >= assignedCourses.size()) {
                            System.out.println("Invalid course index. Please try again.");
                            continue;
                        }
                        Course selectedCourse = assignedCourses.get(courseIndex);
    
                        // Display students in the selected course and get the index of the student to be removed
                        ArrayList<Student> studentList = selectedCourse.getStudentList();
                        if (studentList.isEmpty()) {
                            System.out.println("No students enrolled in this course.");
                            break;
                        }
                        for (int i = 0; i < studentList.size(); i++) {
                            System.out.println((i + 1) + ": " + studentList.get(i).getName());
                        }
                        System.out.println("1: Remove Student   2: Back");
                        int choice2 = session.inputScanner.nextInt();
                        session.inputScanner.nextLine();  // clear the newline left by nextInt()
                        //Menu after selecting a course
                        switch(choice2){
                            case 1: 
                                System.out.print("Index of Student to be removed: ");
                                int studentIndex = session.inputScanner.nextInt() - 1;
                                session.inputScanner.nextLine();  // clear the newline left by nextInt()
                                if (studentIndex < 0 || studentIndex >= studentList.size()) {
                                    System.out.println("Invalid student index. Please try again.");
                                    continue;
                                }
                                Student selectedStudent = studentList.get(studentIndex);
                                selectedCourse.removeStudent(selectedStudent);
                                System.out.println("Student " + selectedStudent.getName() + " removed from " + selectedCourse.getCourseName());
                                break;
                            case 2:
                                backToMenu = true;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }
                    } while (!backToMenu);
                    break;
                case 2:
                    return false;  // logout
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
            System.out.println((i + 1) + ": " + assignedCourses.get(i).getCourseName() + "." + assignedCourses.get(i).getSection());
        }
    }

    public String getTeacherID() {
        return this.teacherID;
    }
    
    // Get a list of the teacher's assigned courses
    public ArrayList<Course> getAssignedCourses() {
        return this.assignedCourses;
    }
}