import java.util.ArrayList;

public class CourseManagement {
    public static void main(String[] args) {
        while (true) {
            Session session = Session.getSession();

            System.out.print("Email: ");
            String email = session.inputScanner.nextLine();
            System.out.print("Password: ");
            String password = session.inputScanner.nextLine();

            try {
                User user = login(email, password);
				if (user != null) {
					boolean continueRunning = user.handleActions();
					if (!continueRunning) {
						break; // Exit the main loop if handleActions returned false.
					}
				}
            }
             catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static User login(String email, String password) throws Exception {
        User[] users = Session.getSession().getUserList();
        for(User user : users) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new Exception("User not found");
    }
    public static void addCourse(Student student, Course course) {
        // Check if the student is already enrolled in a course with the same name
        for (Course c : student.getEnrolledCourses()) {
            if (c.getCourseName().equals(course.getCourseName())) {
                System.out.println("You are already enrolled in this course.");
                return;
            } else if (c.getTiming().equals(course.getTiming())) {
                System.out.println("You have a timing clash with course " + c.getCourseName() + ". Please choose another course or remove a conflicting course.");
                return;
            }
        }
        
        // If not, add the course to the student's list of courses and add the student to the course
        student.getEnrolledCourses().add(course);
        course.addStudent(student);
        System.out.println("You have been enrolled in " + course.getCourseName() + "." + course.getSection() + " successfully!");
    }
    
    //Removes student from a section and removes the course from students enrolledCourses
    public static void removeCourse(Student student, Course course) {
        student.getEnrolledCourses().remove(course);
        course.removeStudent(student);
        System.out.println("You have dropped \"" + course.getCourseName() + "." + course.getSection() + "\" successfully!");
    }

    public static void viewCourses(ArrayList<Course> assignedCourses) {
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
}
