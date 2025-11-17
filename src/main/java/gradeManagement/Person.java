package gradeManagement;

import java.time.LocalDate;

public abstract class Person {
    private int id;
    private String lastName;
    private String firstName;
    private LocalDate birthdate;
    private String email;
    private String phoneNumber;

    public Person(int id, String lastName, String firstName, LocalDate birthdate, String email, String phoneNumber) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthdate = birthdate;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
