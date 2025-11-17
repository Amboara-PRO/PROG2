package gradeManagement;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Grade {
    private Student student;
    private Exam exam;
    private List<GradeChange> historyGrade = new ArrayList<>();

    public Grade(Student student, Exam exam, double initialValue, String reason, Instant timestamp){
        this.student = student;
        this.exam = exam;
        historyGrade.add(new GradeChange(initialValue, reason, timestamp));
    }

    public Student getStudent() {
        return student;
    }
    public Exam getExam() {
        return exam;
    }

    public void addChange(double value, String reason, Instant timestamp) {
        historyGrade.add(new GradeChange(value, reason, timestamp));
    }

    public double getGradeAt(Instant t) {
        GradeChange latest = null;
        for (GradeChange change : historyGrade) {
            if (!change.getTimestamp().isAfter(t)) {
                if (latest == null || change.getTimestamp().isAfter(latest.getTimestamp())){
                    latest = change;
                }
            }
        }
        return latest != null ? latest.getValue() : 0;
    }

}
