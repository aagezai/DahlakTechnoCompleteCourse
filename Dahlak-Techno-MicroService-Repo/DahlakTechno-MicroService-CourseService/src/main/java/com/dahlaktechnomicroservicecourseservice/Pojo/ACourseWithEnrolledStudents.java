package com.dahlaktechnomicroservicecourseservice.Pojo;

import com.dahlaktechnomicroservicecourseservice.Model.Course;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ToString
@Slf4j
public class ACourseWithEnrolledStudents {
    private Course course;
    private Set<Student> studentList;

    public ACourseWithEnrolledStudents(Course course, Set<Student> studentList) {
        log.info("inSideOf ACourseWithEnrolledStudents pojo");
        this.course = course;
        this.studentList = studentList;
    }

    public ACourseWithEnrolledStudents() {
    }

    public Course getCourse() {
        log.info("inSideOf getCourse pojo");
        return course;
    }

    public void setCourse(Course course) {
        log.info("inSideOf setCourse");
        this.course = course;
    }

    public Set<Student> getStudentList() {
        log.info("inSideOf setCourse getStudentList");
        return studentList;
    }

    public void setStudentList(Set<Student> studentList) {
        log.info("inSideO setStudentList");
        this.studentList = studentList;
    }
}
