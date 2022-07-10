package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String courseName;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name= "Course_Student",
            joinColumns = @JoinColumn(name = "courseId"),
            inverseJoinColumns = @JoinColumn(name ="studentId")
    )
    private Set<Student> students = new HashSet<>();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id",referencedColumnName = "teacherId")
    private Teacher teacher;

    public boolean enrollStudent(Student student){
        return students.add(student);
    }



}
