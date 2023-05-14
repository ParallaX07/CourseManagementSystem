# Course Management System

This project is a simple course management system implemented in Java. It allows users such as teachers, students, and teaching assistants to interact with the system and perform various actions related to course management.

## Classes

The main classes in this project are:

1. `CourseManagement`: This is the main/execution class that orchestrates the entire course management system.
2. `User`: An abstract class that represents a user in the system. Specific user types like `Teacher`, `Student`, and `TA` extend this class.
3. `Teacher`: Represents a teacher user and their actions.
4. `Student`: Represents a student user and their actions.
5. `TA`: Represents a teaching assistant user and their actions.
6. `Course`: Manages course information and operations.
7. `Session`: Handles user authentication and input along with the database initialization.
8. `Action`: An interface for handling user actions.

## Features

### Teacher

A teacher can perform the following actions:

1. Add a new course.
2. View their assigned courses.
3. View students enrolled in their courses and remove any student from their course.
4. Log out.

### Teaching Assistant (TA)

A teaching assistant can perform the following actions:

1. View their assigned courses.
2. View students enrolled in their courses.
3. Log out.

### Student

A student can perform the following actions:

1. Enroll in a course.
2. View their enrolled courses.
3. Remove a course.
4. Log out.

### Default Database

**Students**

| Email | Password | Student ID | Student Name | CGPA |
| --- | --- | --- | --- | --- |
| student_a@northsouth.edu | password | S1 | A | 3.4 |
| student_b@northsouth.edu | password | S2 | B | 3.6 |
| student_c@northsouth.edu | password | S3 | C | 3.2 |

**Teachers**

| Email | Password | Teacher ID | Teacher Name |
| --- | --- | --- | --- |
| teacher_a@northsouth.edu | password | T1 | A |
| teacher_b@northsouth.edu | password | T2 | B |

**Assistants**

| Email | Password | Assistant ID | Assistant Name |
| --- | --- | --- | --- |
| assistant_a@northsouth.edu | password | A1 | A |
| assistant_b@northsouth.edu | password | A2 | B |

**Courses**

| Index | Course Name | Section | Timing | Teacher | TA |
| --- | --- | --- | --- | --- | --- |
| 1 | Course A | 1 | A | T1 | A |
| 2 | Course A | 2 | A | T2 | A |
| 3 | Course A | 3 | B | T1 | B |
| 4 | Course B | 1 | A | T1 | A |
| 5 | Course C | 1 | B | T2 | A |
| 6 | Course C | 2 | C | T1 | B |

## Usage

This project is a console-based application. The `CourseManagement` class acts as the main entry point to the program. Here's how you can use it:

1. **Compile the Java Files**: Open a terminal in the directory containing the .java files and run the command `javac *.java`. This compiles all the .java files in the directory.

2. **Run the Application**: Run the `CourseManagement` class using the command `java CourseManagement`. This will start the application.

3. **Interact with the Program**: Once the application starts, it will guide you through a series of prompts. Follow the instructions and input the necessary information when prompted.

    - *Login*: You will be prompted to enter a user type ("teacher", "student", "ta") and ID. The program will validate your input and log you in as the appropriate user type.
    
    - *Perform Actions*: Once logged in, you can perform actions specific to your user type. For instance, a Teacher can add a course, view their assigned courses, view students in their courses, and log out. A Student can enroll in a course, view their enrolled courses, remove a course, and log out. A TA can view their assigned courses, view students in their courses, and log out.

    - *Logging Out and Switching Users*: If you wish to log out and log in as a different user, it is recommend to switch to the `Teacher` at the end. Only the `Teacher` can logout by choosing the logout option in the main menu, the other users can only go back to login screen.

4. **Stop the Application**: You can stop the application by simply closing the terminal or by using the interrupt command specific to your operating system (generally `Ctrl+C`) or through the `logout` option in the Teacher menu.

Please note that this project is a demonstration and does not persist data between sessions. Therefore, all changes you make during a session (such as adding courses or enrolling students) will be lost once the application is stopped.

## Customization
You can customize the project to suit your needs by modifying the .java files. You might want to add more methods to the `User` class or add more functionality to the `Course` class, for instance. Feel free to explore and expand upon this project as you see fit.
