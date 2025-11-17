package gradeManagement;

import java.time.LocalDate;

public class Tutor extends Person {
    private String relationDescription;

    public Tutor(int id, String lastName, String firstName, LocalDate birthdate,
                 String email, String phoneNumber, String relationDescription) {
        super(id, lastName, firstName, birthdate, email, phoneNumber);
        this.relationDescription = relationDescription;
    }
}
