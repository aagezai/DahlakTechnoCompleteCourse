package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String studentName;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "passport_Id",referencedColumnName = "passportId")
    private Passport passport;
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ManyToMany(mappedBy = "students")
    private Set<Course> courses = new HashSet<>();



}
