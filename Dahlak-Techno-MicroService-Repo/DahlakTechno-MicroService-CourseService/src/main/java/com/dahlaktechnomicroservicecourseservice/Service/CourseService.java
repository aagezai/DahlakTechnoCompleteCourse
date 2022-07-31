package com.dahlaktechnomicroservicecourseservice.Service;


import com.dahlaktechnomicroservicecourseservice.Model.Course;
import com.dahlaktechnomicroservicecourseservice.Pojo.ACourseWithEnrolledStudents;
import com.dahlaktechnomicroservicecourseservice.Pojo.CourseEnrolledByStudent;

import java.util.List;

public interface CourseService {
    public Course saveCourse(Course course);
    public Course getCourseById(Integer courseId);
    public List<Course> getAllCourses();
    public Course deleteCourseById(Integer courseId);
    public CourseEnrolledByStudent enrolledStudent(Integer courseId, Integer studentId) throws Exception;
    Course assignCourseToTeacher(Integer courseId, Integer teacherId);

    ACourseWithEnrolledStudents getACourseWithEnrolledStudents(Integer courseId);
}
