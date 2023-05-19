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
        this.teacher.setEnrolledCourses(this);
        this.teachingAssistant.setEnrolledCourses(this);
    }

    // Add a student to the course
    public void addStudent(Student student) {
        if (students.size() < capacity && !students.contains(student)) {
            this.students.add(student);
        } else {
            System.out.println("This course is full.");
        }
    }

    public void removeStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
        } else {
            System.out.println("Student " + student.getName() + " is not enrolled in " + courseName + "." + section + ".");
        }
    }

    //Displays students in a particular course
    public void viewStudentList() {
        if (this.students.isEmpty()) {
            System.out.println("No students enrolled in this course.");
            return;
        }
        for (int i = 0; i < this.students.size(); i++) {
            System.out.println((i + 1) + ". " + "Student Name: " + this.students.get(i).getName() + ", Student ID: " + this.students.get(i).getUserID());
        }
    }

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