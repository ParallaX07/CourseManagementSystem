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

    // Add a course to the student's enrolled courses
    public void addCourse(Course course) {
        // Check if the student is already enrolled in a course with the same name
        for (Course c : enrolledCourses) {
            if (c.getCourseName().equals(course.getCourseName())) {
                System.out.println("You are already enrolled in this course.");
                return;
            } else if(c.getTiming().equals(course.getTiming())){
                System.out.println("You have a timing clash with course " + c.getCourseName() + ". Please choose another course, or remove course and select another timing.");
                return;
            }
        }
    
        // If not, add the course to the student's list of courses and add the student to the course
        enrolledCourses.add(course);
        course.addStudent(this);  // add this line
        System.out.println("You have been enrolled in " + course.getCourseName() + "." + course.getSection() + " successfully!");
    }
    

    // Remove a course from the student's enrolled courses
    public void removeCourse(Course course) {
        this.enrolledCourses.remove(course);
    }

    // Get a list of the student's enrolled courses
    public ArrayList<Course> getEnrolledCourses() {
        return this.enrolledCourses;
    }

    // Implement the handleActions() method from the Action interface
    @Override
    public boolean handleActions() {
        while (true) {
            System.out.println("1: Add Course\n2: View Courses\n3: Remove Course\n4: Back");
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
                    addCourse(courseList[indexToAdd]);
                    break;
                case 2:
                    viewCourses();
                    break;
                case 3:
                    // Display enrolled courses and get the index of the course to be removed
                    for (int i = 0; i < enrolledCourses.size(); i++) {
                        System.out.println((i + 1) + ": " + enrolledCourses.get(i).getCourseName());
                    }
                    System.out.print("Index of Course to be removed: ");
                    int indexToRemove = session.readUserChoice() - 1;
                    removeCourse(enrolledCourses.get(indexToRemove));
                    break;
                case 4:
                    return true;  // logout
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

	public void viewCourses() {
        // Display enrolled courses
        System.out.println("Enrolled Courses:");
        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses to show.");
        }
        else {    for (int i = 0; i < enrolledCourses.size(); i++) {
                System.out.println((i + 1) + ": " + enrolledCourses.get(i).getCourseName() + "." + enrolledCourses.get(i).getSection());
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