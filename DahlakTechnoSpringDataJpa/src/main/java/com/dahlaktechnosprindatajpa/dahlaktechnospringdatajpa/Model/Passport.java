package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer passportId;
    private String  passportName;
    @OneToOne
    @JoinColumn(name = "student_Id",referencedColumnName = "studentId")
    private Student studentWithPassport;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passport)) return false;
        Passport passport = (Passport) o;
        return getPassportId().equals(passport.getPassportId()) && getPassportName().equals(passport.getPassportName()) && getStudentWithPassport().equals(passport.getStudentWithPassport());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassportId(), getPassportName(), getStudentWithPassport());
    }
}
