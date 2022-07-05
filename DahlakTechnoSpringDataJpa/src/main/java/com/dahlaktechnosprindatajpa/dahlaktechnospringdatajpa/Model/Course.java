package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String courseName;
    @ManyToMany
    @JoinTable(
            name= "Course_Student",
            joinColumns = @JoinColumn(name = "courseId"),
            inverseJoinColumns = @JoinColumn(name ="studentId")
    )
    private List<Student> enrolledStudents = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "teacher_id",referencedColumnName = "teacherId")
    private Teacher assignedTeacher;

    public boolean enrollStudent(Student student){
        return enrolledStudents.add(student);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getCourseId().equals(course.getCourseId()) && getCourseName().equals(course.getCourseName()) && getEnrolledStudents().equals(course.getEnrolledStudents()) && getAssignedTeacher().equals(course.getAssignedTeacher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseId(), getCourseName(), getEnrolledStudents(), getAssignedTeacher());
    }
}
