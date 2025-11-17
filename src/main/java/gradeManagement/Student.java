package gradeManagement;

import java.time.LocalDate;

public class Student extends Person {
    private String group;
    private Tutor tutor;

    public Student(int id, String lastName, String firstName, LocalDate birthdate, String email,
                   String phoneNumber, String group, Tutor tutor) {
        super(id, lastName, firstName, birthdate, email, phoneNumber);
        this.group = group;
        this.tutor = tutor;
    }
}
