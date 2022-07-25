package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Controller;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Course;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Student;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.ServiceImpl.CourseServiceImpl;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.ServiceImpl.StudentServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private CourseServiceImpl courseServiceImpl;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    public CourseController(CourseServiceImpl courseServiceImpl) {
        this.courseServiceImpl = courseServiceImpl;
    }
    @PostMapping("/course")
    public Course saveCourse(@RequestBody Course course){
        logger.info("save a course called");
        return courseServiceImpl.saveCourse(course);

    }
    @DeleteMapping("/course/{courseId}")
    public void deleteCourseById(@PathVariable Integer courseId){
        logger.info("delete course by Id called");
         courseServiceImpl.deleteCourseById(courseId);
    }
    @GetMapping("/course/{courseId}")
    public Course getCourseById(@PathVariable Integer courseId){
        logger.info("getCourseById called");
        return courseServiceImpl.getCourseById(courseId);
    }
    @GetMapping("/course")
    public List<Course> getAllCourses(){
        logger.info("getAllCourses called");
        return courseServiceImpl.getAllCourses();
    }
    @PutMapping("/course/{courseId}/student/{studentId}")
    public Course enrollStudent(@PathVariable Integer courseId, @PathVariable Integer studentId) throws Exception {
        logger.info("enrollStudent called");
        return courseServiceImpl.enrolledStudent(courseId,studentId);
    }
    @PutMapping("/course/{courseId}/teacher/{teacherId}")
    public Course assignCourseToTeacher(@PathVariable Integer courseId, @PathVariable Integer teacherId) throws Exception {
        logger.info("assignCourseToTeacher called");
        return courseServiceImpl.assignCourseToTeacher(courseId,teacherId);
    }


}
