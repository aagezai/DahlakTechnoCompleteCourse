package com.dahlakTechnoMicroserviceStudentService.Model;


import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Student {
    @Id
    private Integer studentId;
    private String studentName;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "passport_Id",referencedColumnName = "passportId")
    private Passport passport;
    @ElementCollection
    private Set<Integer> courses = new HashSet<>();


    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Set<Integer> getCourses() {
        return courses;
    }

    public void setCourses(Set<Integer> courses) {
        this.courses = courses;
    }
}
