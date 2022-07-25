package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Course {
    @Id
    private Integer courseId;
    private String courseName;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name= "Course_Student",
            joinColumns = @JoinColumn(name = "courseId"),
            inverseJoinColumns = @JoinColumn(name ="studentId")
    )
    private Set<Student> students = new HashSet<>();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id",referencedColumnName = "teacherId")
    private Teacher teacher;


    public boolean enrollStudent(Student student) {
        System.out.println(students+"///////////////");
        return students.add(student);
    }
}
