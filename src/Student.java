import java.util.ArrayList;

public class Student extends User {
    private String studentID;
    private double CGPA;
    private ArrayList<Course> enrolledCourses;

    public Student(String email, String password, String name, String studentID, double CGPA) {
        super(email, password, name);
        this.studentID = studentID;
        this.CGPA = CGPA;
        this.enrolledCourses = new ArrayList<>();
    }

    // Get a list of the student's enrolled courses
    public ArrayList<Course> getEnrolledCourses() {
        return this.enrolledCourses;
    }

    // Implement the handleActions() method from the Action interface
    @Override
    public boolean handleActions() {
        while (true) {
            System.out.println("1: Add Course   2: View Courses     3: Back");
            System.out.print("> ");
            Session session = Session.getSession();
            int choice = session.readUserChoice();

            switch (choice) {
                case 1:
                    // Display available courses and get the index of the course to be added
                    Course[] courseList = session.getCourseList();
                    for (int i = 0; i < courseList.length; i++) {
                        System.out.println((i + 1) + ": " + courseList[i].getCourseName() + "." + courseList[i].getSection());
                    }
                    System.out.print("Index of the Course to be added: ");
                    int indexToAdd = session.readUserChoice() - 1;
                    if (indexToAdd < 0 || indexToAdd >= courseList.length) {
                        System.out.println("Invalid course index. Please try again.");
                        continue;
                    }
                    Course courseToAdd = courseList[indexToAdd];
                    CourseManagement.addCourse(this, courseToAdd);
                    break;
                case 2:
                System.out.println("Enrolled Courses:");
                    CourseManagement.viewCourses(this.enrolledCourses);
                    System.out.println();

                    System.out.println("1: Remove Course   2: Back");
                    System.out.print("> ");
                    int choice2 = session.readUserChoice();
                    switch(choice2){
                        case 1:
                            // Display enrolled courses and get the index of the course to be removed
                            CourseManagement.viewCourses(this.enrolledCourses);
                            System.out.print("Index of Course to be removed: ");
                            int indexToRemove = session.readUserChoice() - 1;
                            Course courseToRemove = enrolledCourses.get(indexToRemove);
                            CourseManagement.removeCourse(this, courseToRemove);
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                    break;
                case 3:
                    return true;  // goBack
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public String getStudentID() {
        return this.studentID;
    }

    public double getCGPA() {
        return this.CGPA;
    }

}