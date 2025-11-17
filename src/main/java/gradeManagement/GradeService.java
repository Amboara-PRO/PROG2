package gradeManagement;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class GradeService {

    private List<Grade> grades;

    public GradeService() {
        this.grades = new ArrayList<>();
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public double getExamGrade(Exam exam, Student student, Instant t) {
        return grades.stream()
                .filter(grade -> grade.getExam().equals(exam) && grade.getStudent().equals(student))
                .findFirst()
                .map(grade -> grade.getGradeAt(t))
                .orElse(0.0);
    }

    public double getCourseGrade(Course course, Student student, Instant t) {
        double sumWeighted = grades.stream()
                .filter(grade -> grade.getExam().getCourse().equals(course)
                        && grade.getStudent().equals(student))
                .mapToDouble(grade -> grade.getGradeAt(t) * grade.getExam().getCoefficient())
                .sum();

        int sumCoeff = grades.stream()
                .filter(grade -> grade.getExam().getCourse().equals(course)
                        && grade.getStudent().equals(student))
                .mapToInt(g -> g.getExam().getCoefficient())
                .sum();

        if (sumCoeff == 0) return 0.0;

        return sumWeighted / sumCoeff;
    }
}
