// Subclass for LabCourse
class LabCourse extends Course {
    private int numberOfLabs;

    public LabCourse(String courseCode, String title, String instructor, int maxCapacity, int units, String career, int numberOfLabs) {
        super(courseCode, title, instructor, maxCapacity, units, career);
        this.numberOfLabs = numberOfLabs;
    }

    @Override
    public void generateSchedule() {
        System.out.println("Schedule for " + title + " labs is generated with " + numberOfLabs + " labs.");
    }
}