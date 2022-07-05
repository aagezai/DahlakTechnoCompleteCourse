package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;
    private String teacherName;
    @JsonIgnore
    @OneToMany(mappedBy = "assignedTeacher",cascade = CascadeType.ALL)
    private List<Course> assignedCourses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return teacherId.equals(teacher.teacherId) && teacherName.equals(teacher.teacherName) && assignedCourses.equals(teacher.assignedCourses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, teacherName, assignedCourses);
    }
}
