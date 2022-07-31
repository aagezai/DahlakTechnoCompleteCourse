package com.dahlaktechnomicroservicecourseservice.Controller;
import com.dahlaktechnomicroservicecourseservice.Model.Course;
import com.dahlaktechnomicroservicecourseservice.Pojo.ACourseWithEnrolledStudents;
import com.dahlaktechnomicroservicecourseservice.Pojo.CourseEnrolledByStudent;
import com.dahlaktechnomicroservicecourseservice.Service.ServiceImpl.CourseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/courses")
@Slf4j
public class CourseController {

    private CourseServiceImpl courseServiceImpl;
    @Autowired
    public CourseController(CourseServiceImpl courseServiceImpl) {
        this.courseServiceImpl = courseServiceImpl;
    }
    @PostMapping("/course")
    public Course saveCourse(@RequestBody Course course){
        log.info("save a course called");
        return courseServiceImpl.saveCourse(course);

    }
    @DeleteMapping("/course/{courseId}")
    public void deleteCourseById(@PathVariable Integer courseId){
        log.info("delete course by Id called");
         courseServiceImpl.deleteCourseById(courseId);
    }
    @GetMapping("/course/{courseId}")
    public Course getCourseById(@PathVariable Integer courseId){
        log.info("getCourseById called");
        return courseServiceImpl.getCourseById(courseId);
    }
    @GetMapping("/course")
    public List<Course> getAllCourses(){
        log.info("getAllCourses called");
        return courseServiceImpl.getAllCourses();
    }
    @PutMapping("/course/{courseId}/student/{studentId}")
    public CourseEnrolledByStudent enrollStudent(@PathVariable Integer courseId, @PathVariable Integer studentId) throws Exception {
        log.info("enrollStudent called");
        return courseServiceImpl.enrolledStudent(courseId,studentId);
    }
    @PutMapping("/course/{courseId}/teacher/{teacherId}")
    public Course assignCourseToTeacher(@PathVariable Integer courseId, @PathVariable Integer teacherId) throws Exception {
        log.info("assignCourseToTeacher called");
        return courseServiceImpl.assignCourseToTeacher(courseId,teacherId);
    }
    @GetMapping("/courseWithEnrolledStudents/{courseId}")
    public ACourseWithEnrolledStudents getACourseWithEnrolledStudents(@PathVariable Integer courseId) {
        log.info("inSide getACourseWithEnrolledStudents");
        return courseServiceImpl.getACourseWithEnrolledStudents(courseId);

    }
}
