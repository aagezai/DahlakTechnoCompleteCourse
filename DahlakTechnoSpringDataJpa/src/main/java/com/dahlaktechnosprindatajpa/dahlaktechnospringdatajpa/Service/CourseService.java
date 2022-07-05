package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Course;

public interface CourseService {
    public Course saveCourse(Course course);
    public Course getCourseById(Integer courseId);
    public Course deleteCourseById(Integer courseId);


}
