package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Controller;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Course;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Student;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.ServiceImpl.CourseServiceImpl;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.ServiceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses/")
public class CourseController {
    private CourseServiceImpl courseServiceImpl;

    @Autowired
    public CourseController(CourseServiceImpl courseServiceImpl) {
        this.courseServiceImpl = courseServiceImpl;
    }
    @PostMapping("/course")
    public Course saveCourse(@RequestBody Course course){
        return courseServiceImpl.saveCourse(course);
    }
    @DeleteMapping("/student/{courseId}")
    public Course deleteCourseById(@PathVariable Integer courseId){
        return courseServiceImpl.deleteCourseById(courseId);
    }
    @GetMapping("/course/{courseId}")
    public Course getCourseById(@PathVariable Integer courseId){
        return courseServiceImpl.getCourseById(courseId);
    }
    @PutMapping("/course/{courseId}/student/{studentId}")
    public Course enrollStudent(@PathVariable Integer courseId, @PathVariable Integer studentId) throws Exception {

        return courseServiceImpl.enrolledStudent(courseId,studentId);
    }

}
