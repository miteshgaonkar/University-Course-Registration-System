class SeminarCourse extends Course {
    private String seminarLeader;

    public SeminarCourse(String courseCode, String title, String instructor, int maxCapacity, int units, String career, String seminarLeader) {
        super(courseCode, title, instructor, maxCapacity, units, career);
        this.seminarLeader = seminarLeader;
    }

    @Override
    public void generateSchedule() {
        System.out.println("Schedule for " + title + " seminar is generated. Leader: " + seminarLeader);
    }

    @Override
    public void displayCourseDetails() {
        System.out.print("Course Code: " + courseCode);
        System.out.print(", Title: " + title);
        System.out.print(", Instructor: " + instructor);
        System.out.print(", Maximum Capacity: " + maxCapacity);
        System.out.print(", Enrolled Students: " + enrolledStudents.size());
        System.out.print(", Available Seats: "+ (maxCapacity - enrolledStudents.size()));
        System.out.print(", Status: " + status);
        System.out.print(", Seminar Leader: " +seminarLeader);
    }
}