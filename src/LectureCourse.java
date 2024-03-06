
public class LectureCourse extends Course {
	private int numberOfSections;

    public LectureCourse(String courseCode, String title, String instructor, int maxCapacity, int units, String career, int numberOfSections) {
        super(courseCode, title, instructor, maxCapacity, units, career);
        this.numberOfSections = numberOfSections;
    }

    @Override
    public void generateSchedule() {
        System.out.println("Schedule for " + title + " lectures is generated with " + numberOfSections + " sections.");
    }

}
