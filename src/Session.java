import java.util.Scanner;

public class Session {
    private static Session session = null;
    private User[] userList;
    private Course[] courseList;
    public Scanner inputScanner;

    private Session() {
        this.inputScanner = new Scanner(System.in);
        createDatabase();
    }

    private void createDatabase() {
        // Initialize userList
        userList = new User[7];
        userList[0] = new Student("student_a@northsouth.edu", "password", "A", "S1", 3.4);
        userList[1] = new Student("student_b@northsouth.edu", "password", "B", "S2", 3.6);
        userList[2] = new Student("student_c@northsouth.edu", "password", "C", "S3", 3.2);
        userList[3] = new Teacher("teacher_a@northsouth.edu", "password", "A", "T1");
        userList[4] = new Teacher("teacher_b@northsouth.edu", "password", "B", "T2");
        userList[5] = new TA("assistant_a@northsouth.edu", "password", "A", "A1");
        userList[6] = new TA("assistant_b@northsouth.edu", "password", "B", "A2");

        // Initialize courseList
        courseList = new Course[6];
        courseList[0] = new Course("Course A", 1, "A", (Teacher) userList[3], (TA) userList[5]);
        courseList[1] = new Course("Course A", 2, "A", (Teacher) userList[4], (TA) userList[5]);
        courseList[2] = new Course("Course A", 3, "B", (Teacher) userList[3], (TA) userList[6]);
        courseList[3] = new Course("Course B", 1, "A", (Teacher) userList[3], (TA) userList[5]);
        courseList[4] = new Course("Course C", 1, "B", (Teacher) userList[4], (TA) userList[5]);
        courseList[5] = new Course("Course C", 2, "C", (Teacher) userList[3], (TA) userList[6]);
    }

    public static Session getSession() {
        if (session == null)
            session = new Session();
        return session;
    }

    public Course[] getCourseList() {
        return courseList;
    }

    public User[] getUserList() {
        return userList;
    }
}