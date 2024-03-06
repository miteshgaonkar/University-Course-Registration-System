import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseRegistrationSystem {
    public static List<Course> createCourses() {
        List<Course> courses = new ArrayList<>();

        Course course1 = new LectureCourse("CSE501", "Introduction to Data Science", "Prof. Clark", 25, 3, "UG", 5);
        Course course2 = new SeminarCourse("PHE006", "Reproductive Ethics", "Prof. Doak", 60, 3, "UG", "Dr. Salah");
        courses.add(course1);
        courses.add(course2);
        Course course3 = new LectureCourse("CSE687", "Introduction to Object Oreinted Design", "Prof. Joseph Waclawski", 10, 3, "PG", 2);
        Course course4 = new SeminarCourse("PHE201", "Public Health Ethics", "Prof. Tom Heaton", 50, 3, "PG", "Dr. Brown");
        Course course5 = new LectureCourse("CSE523", "Introduction to Object Oreinted Programming", "Prof. Roger Chen", 25, 3, "PG", 5);
        course3.prerequisites.add(0,course5);
        courses.add(course3);
        course4.prerequisites.add(0,course2);
        courses.add(course4);
        courses.add(course5);
        courses.add(new LabCourse("BIO786", "Biomedical", "Dr. Cole Palmer", 3, 3, "PG", 3));
        courses.add(new LectureCourse("CSE502", "Introduction to Machine Learning", "Prof. Mark", 25, 3, "UG", 5));
        courses.add(new SeminarCourse("PHE706", "Dinning Ethics", "Prof. Michel", 60, 3, "UG", "Dr. Salah"));
        return courses;
    }

    public static Course findCourse(List<Course> courses, String courseCode) {
        for (Course course : courses) {
            if (course.courseCode.equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = createCourses();
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\nWelcome to the University Course Registration System");
            System.out.println("1. List all courses");
            System.out.println("2. Enroll in a course");
            System.out.println("3. List my courses");
            System.out.println("4. See course prerequisites");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                for (Course course : courses) {
                    // System.out.println(course.courseCode + ": " + course.title + ", Instructor: " + course.instructor +", Available Seats: " + (course.maxCapacity - course.enrolledStudents.size())+", Status: "+course.status);
                    course.displayCourseDetails();
                    System.out.println();
                }
            } else if (choice.equals("2")) {
                System.out.print("Enter your student ID: ");
                String studentId = scanner.nextLine();
                System.out.print("Enter your name: ");
                String studentName = scanner.nextLine();
                boolean case1 = false;
                String studentDegree = "PG";
                do{  
                    System.out.print("Enter your degree(UG/PG): ");
                    studentDegree = scanner.nextLine();
                    if(!(studentDegree.equalsIgnoreCase("UG") || studentDegree.equalsIgnoreCase("PG") )){
                        case1 = true;
                    }
                }while(case1);
                

                System.out.print("Enter the course code you want to enroll in: ");
                String courseCode = scanner.nextLine();

                Student student = null;
                for (Student s : students) {
                    if (s.getStudentID().equals(studentId)) {
                        student = s;
                        break;
                    }
                }
                if (student == null) {
                    student = new Student(studentId, studentName,studentDegree);
                    students.add(student);
                }

                Course course = findCourse(courses, courseCode);
                if (course != null) {
                    if (course.enrollStudent(student)) {
                        System.out.println("Successfully enrolled in " + course.title + ".");
                        course.generateSchedule();
                    } else {
                        System.out.println("Failed to enroll. The course may be full or you're already enrolled or degree doesn't match with the course or doesn't meet prerequisites.");
                    }
                } else {
                    System.out.println("Course not found.");
                }
            } else if (choice.equals("3")) {
                System.out.print("Enter your student ID: ");
                String studentId = scanner.nextLine();
                Student student = null;
                for (Student s : students) {
                    if (s.getStudentID().equals(studentId)) {
                        student = s;
                        break;
                    }
                }
                if (student != null) {
                    System.out.println("Enrolled courses for " + student.getName() + ":");
                    for (Course course : courses) {
                        if (course.enrolledStudents.contains(student)) {
                            System.out.println(course.title);
                        }
                    }
                } else {
                    System.out.println("Student not found. Please enroll in a course first.");
                }
            } else if (choice.equals("4")) {
                System.out.print("Enter the course code to see prerequisites: ");
                String courseCode = scanner.nextLine();
                Course course = findCourse(courses, courseCode);
                if (course != null) {
                    System.out.println();
                    System.out.print("Prerequisites for " + course.title + ": ");
                    if(!course.prerequisites.isEmpty())
                        System.out.print(course.prerequisites.get(0).title);
                    else 
                        System.out.println("0");
                } else {
                    System.out.println("Course not found.");
                }
            } else if (choice.equals("5")) {
                System.out.println("Exiting the system. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}