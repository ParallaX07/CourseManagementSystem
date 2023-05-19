import java.util.ArrayList;

public abstract class User implements Action{
    private String email;
    private String password;
    private String name;
    private String id;
    private ArrayList<Course> enrolledCourses = new ArrayList<>();

    protected User(String email, String password, String name, String id) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.id = id;
    }


    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;
    }

    public String getUserID() {
        return this.id;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return this.enrolledCourses;
    }

    public void setEnrolledCourses(Course course) {
        this.enrolledCourses.add(course);
    }
}