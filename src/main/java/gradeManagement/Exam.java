package gradeManagement;

import java.time.Instant;

public class Exam {
    private int id;
    private String title;
    private Course course;
    private Instant dateTime;
    private int coefficient;

    public Exam(int id, String title, Course course, Instant dateTime, int coefficient) {
        this.id = id;
        this.title = title;
        this.course = course;
        this.dateTime = dateTime;
        this.coefficient = coefficient;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public Course getCourse() {
        return course;
    }
}
