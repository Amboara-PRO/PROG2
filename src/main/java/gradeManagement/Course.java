package gradeManagement;

public class Course {
    private int id;
    private String label;
    private int credits;
    private Teacher teacher;

    public Course(int id, String label, int credits, Teacher teacher) {
        this.id = id;
        this.label = label;
        this.credits = credits;
        this.teacher = teacher;
    }
}
