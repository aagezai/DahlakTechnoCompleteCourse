package com.dahlakTechnoMicroserviceStudentService.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
@AllArgsConstructor
@NoArgsConstructor

@ToString
@Builder
public class Passport {
    @Id
    private Integer passportId;
    private String passportName;
    @JsonIgnore
    @OneToOne(mappedBy = "passport")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Student student;

    public Integer getPassportId() {
        return passportId;
    }

    public void setPassportId(Integer passportId) {
        this.passportId = passportId;
    }

    public String getPassportName() {
        return passportName;
    }

    public void setPassportName(String passportName) {
        this.passportName = passportName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}