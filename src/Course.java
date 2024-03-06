import java.util.ArrayList;
import java.util.List;

class Course {
    protected String courseCode;
    protected String title;
    protected String instructor;
    protected int maxCapacity;
    protected List<Student> enrolledStudents;
    protected String status;
    protected int units;
    protected String career;
    protected List<Course> prerequisites;

    public Course(String courseCode, String title, String instructor, int maxCapacity, int units, String career) {
        this.courseCode = courseCode;
        this.title = title;
        this.instructor = instructor;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
        this.status = "Open";
        this.units = units;
        this.career = career;
        this.prerequisites = new ArrayList<>();
    }

    // Method to enroll student
    public boolean enrollStudent(Student student) {
        if(!enrolledStudents.contains(student) && career.equalsIgnoreCase(student.getCareer())){
            if (enrolledStudents.size() < maxCapacity) {
                enrolledStudents.add(student);
                return true;
            } else{
                status = "Closed";
                return false;
            }
        }        
        return false;
    }

    // Method to check if student meets prerequisites
    public boolean meetsPrerequisites(Student student) {
        for (Course prerequisite : prerequisites) {
            if (!student.isEnrolledIn(prerequisite)) {
                return false;
            }
        }
        return true;
    }

    public void generateSchedule() {
        System.out.println("Schedule for " + title + " is generated.");
    } 

    public void displayCourseDetails() {
        System.out.print("Course Code: " + courseCode);
        System.out.print(", Title: " + title);
        System.out.print(", Instructor: " + instructor);
        System.out.print(", Maximum Capacity: " + maxCapacity);
        System.out.print(", Enrolled Students: " + enrolledStudents.size());
        System.out.print(", Available Seats: "+ (maxCapacity - enrolledStudents.size()));
        System.out.print(", Status: " + status);
    }
    
    
}
