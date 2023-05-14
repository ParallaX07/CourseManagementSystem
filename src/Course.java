import java.util.ArrayList;

public class Course {
    private String courseName;
    private int section;
    private String timing;
    private Teacher teacher;
    private TA teachingAssistant;
    private ArrayList<Student> students;
    private int capacity = 5; // Student capacity for a course

    public Course(String courseName, int section, String timing, Teacher teacher, TA teachingAssistant) {
        this.courseName = courseName;
        this.section = section;
        this.timing = timing;
        this.teacher = teacher;
        this.teachingAssistant = teachingAssistant;
        this.students = new ArrayList<>();
    }

    // Add a student to the course
    public void addStudent(Student student) {
        if (students.size() < capacity) {
            this.students.add(student);
        } else {
            System.out.println("This course is full.");
        }
    }

    // Remove a student from the course
    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    // Get a list of students in the course
    public ArrayList<Student> getStudentList() {
        return this.students;
    }

    // other methods specific to the course

    public String getCourseName() {
        return this.courseName;
    }

    public int getSection() {
        return this.section;
    }

    public String getTiming() {
        return this.timing;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public TA getTeachingAssistant() {
        return this.teachingAssistant;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public int getCapacity() {
        return this.capacity;
    }
}