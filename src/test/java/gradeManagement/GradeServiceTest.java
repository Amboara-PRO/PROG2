package gradeManagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

public class GradeServiceTest {

    private GradeService manager;
    private Student student;
    private Tutor tutor;
    private Teacher teacher;
    private Course course;
    private Exam exam1;
    private Exam exam2;

    private Instant t1, t2, t3;

    @BeforeEach
    void setUp() {
        manager = new GradeService();

        tutor = new Tutor(1, "Doe", "Tutor", LocalDate.of(1980, 1, 1),
                "tutor@mail.com", "000", "Tutor principal");

        teacher = new Teacher(20, "Smith", "John", LocalDate.of(1975, 5, 5),
                "prof@mail.com", "111", "Java");

        student = new Student(50, "Randria", "Kezia", LocalDate.of(2004, 4, 14),
                "kezia@mail.com", "222", "G1", tutor);

        course = new Course(100, "PROG2", 6, teacher);

        exam1 = new Exam(
                200,
                "DS1",
                course,
                LocalDateTime.of(2025, 1, 10, 10, 0).toInstant(ZoneOffset.UTC),
                2
        );

        exam2 = new Exam(
                201,
                "DS2",
                course,
                LocalDateTime.of(2025, 1, 20, 10, 0).toInstant(ZoneOffset.UTC),
                3
        );

        t1 = Instant.parse("2025-01-01T00:00:00Z");
        t2 = Instant.parse("2025-01-15T00:00:00Z");
        t3 = Instant.parse("2025-02-01T00:00:00Z");

        Grade g1 = new Grade(student, exam1, 10, "Fault", t1);
        g1.addChange(12.0, "Correction", t2);

        Grade g2 = new Grade(student, exam2, 15, "Error", t1);
        g2.addChange(18,"Late reassessment", t3);

        manager.addGrade(g1);
        manager.addGrade(g2);
    }

    @Test
    void testGetExamGrade_beforeUpdate() {
        double grade = manager.getExamGrade(exam1, student, t1);
        assertEquals(10.0, grade);
    }

    @Test
    void testGetExamGrade_afterUpdate() {
        double grade = manager.getExamGrade(exam1, student, t2);
        assertEquals(12.0, grade);
    }

    @Test
    void testGetCourseGrade_initialValues() {
        double grade = manager.getCourseGrade(course, student, t1);
        assertEquals(13.0, grade);
    }

    @Test
    void testGetCourseGrade_afterAllUpdates() {
        double grade = manager.getCourseGrade(course, student, t3);
        assertEquals(15.6, grade);
    }
}
