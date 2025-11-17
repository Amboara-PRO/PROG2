package gradeManagement;

import java.time.LocalDate;

public class Teacher extends Person{
    private String specialty;

    public Teacher(int id, String lastName, String firstName, LocalDate birthdate,
                   String email, String phoneNumber, String specialty) {
        super(id, lastName, firstName, birthdate, email, phoneNumber);
        this.specialty = specialty;
    }
}
