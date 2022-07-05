package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String studentName;

    @OneToOne
    @JoinColumn(name = "passport_Id",referencedColumnName = "passportId")
    private Passport studentPassport;
    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents", cascade = CascadeType.ALL)
    private Set<Course> registeredCourses = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getStudentId().equals(student.getStudentId()) && getStudentName().equals(student.getStudentName()) && getRegisteredCourses().equals(student.getRegisteredCourses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getStudentName(), getRegisteredCourses());
    }
}
