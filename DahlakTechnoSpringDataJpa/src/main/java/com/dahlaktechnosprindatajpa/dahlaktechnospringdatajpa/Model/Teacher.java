package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;
    private String teacherName;
    @JsonIgnore
    @OneToMany(mappedBy = "assignedTeacher",cascade = CascadeType.ALL)
    private Set<Course> assignedCourses = new HashSet<>();

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
