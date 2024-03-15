# University Course Registration System

This is a Java application that simulates a course registration system for a university. It allows students to enroll in courses, view their enrolled courses, and check course prerequisites.
Additionally, it includes different types of courses, such as lecture courses, seminar courses, and lab courses.

## Features

- **Course Registration**: Students can enroll in available courses based on their career (Undergraduate or Postgraduate) and course capacity.
- **Course Prerequisites**: Courses can have prerequisites, and the system checks if a student meets the prerequisites before enrolling them in a course.
- **Course Types**: The application supports different types of courses:
  - Lecture Courses: Courses with multiple sections/lectures.
  - Seminar Courses: Courses with a seminar leader.
  - Lab Courses: Courses with a specified number of lab sessions.
- **Course Details**: Students can view course details, including the course code, title, instructor, maximum capacity, enrolled students, available seats, and status (open or closed).
- **Student Management**: Students can be added to the system, and their enrolled courses can be displayed.

## Getting Started

1. Clone the repository: `git clone https://github.com/your-username/university-course-registration.git`

2. Navigate to the project directory: `cd university-course-registration`

3. Compile and run the main class `CourseRegistrationSystem.java`.
`javac CourseRegistrationSystem.java`
`java CourseRegistrationSystem`

4. Follow the prompts in the console to interact with the course registration system.

## Project Structure

- `Course.java`: Base class for courses, containing common properties and methods.
- `LectureCourse.java`: Subclass representing lecture courses with sections/lectures.
- `SeminarCourse.java`: Subclass representing seminar courses with a seminar leader.
- `LabCourse.java`: Subclass representing lab courses with a specified number of lab sessions.
- `Student.java`: Class representing students, with methods for enrolling in courses and displaying enrolled courses.
- `CourseRegistrationSystem.java`: Main class containing the entry point and menu-driven interface for the application.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.
