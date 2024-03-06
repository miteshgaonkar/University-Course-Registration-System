import java.util.ArrayList;
import java.util.List;

// Student class
class Student {
    private String studentID;
    private String name;
    private String career;
    private List<Course> enrolledStudentCourses;

    public Student(String studentID, String name, String career) {
        this.studentID = studentID;
        this.name = name;
        this.career = career;
        this.enrolledStudentCourses = new ArrayList<>();
    }

    //Method enroll student
    public void enrollCourse(Course course) {
        enrolledStudentCourses.add(course);
    }

    //Display Enrolled Courses
    public void displayEnrolledCourses() {
        System.out.println(name + "'s Enrolled Courses:");
        for (Course course : enrolledStudentCourses) {
            course.displayCourseDetails();
        }
    }

    public boolean isEnrolledIn(Course course) {
        return enrolledStudentCourses.contains(course);
    }

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}
}