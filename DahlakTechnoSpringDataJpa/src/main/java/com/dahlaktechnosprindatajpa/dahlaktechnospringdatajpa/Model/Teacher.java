package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    @Id
    private Integer teacherId;
    private String teacherName;
    @JsonIgnore
    @OneToMany(mappedBy = "students")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Set<Course> courses = new HashSet<>();



}
