package gradeManagement;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor

public abstract class Person {
    private int id;
    private String lastName;
    private String firstName;
    private LocalDate birthdate;
    private String email;
    private String phoneNumber;
}
