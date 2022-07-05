package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.ServiceImpl;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Course;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Repository.CourseRepository;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Integer courseId) {
        return courseRepository.findById(courseId).get();
    }

    @Override
    public Course deleteCourseById(Integer courseId) {
        return null;
    }
}
