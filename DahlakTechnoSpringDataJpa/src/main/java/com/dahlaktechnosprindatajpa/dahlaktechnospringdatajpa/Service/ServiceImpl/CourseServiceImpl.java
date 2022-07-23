package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.ServiceImpl;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Exception.ResourceNotFoundException;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Course;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Student;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Teacher;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Repository.CourseRepository;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StudentServiceImpl studentServiceImpl;
    @Autowired
    private TeacherServiceImpl teacherServiceImpl;

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
        logger.info("inside of getById ++");
        return courseRepository.findById(courseId).
                orElseThrow(() -> new ResourceNotFoundException("course","courseId",courseId));
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course deleteCourseById(Integer courseId) {
        logger.info("inside of deleteById ++");
        Course course = getCourseById(courseId);
        courseRepository.deleteById(courseId);
        return course;
    }

    @Override
    public Course enrolledStudent(Integer courseId, Integer studentId) throws Exception {
        Course course = getCourseById(courseId);
        Student student = studentServiceImpl.getStudentById(studentId);
        boolean isEnrolled = course.enrollStudent(student);
        Course persistedCourse = saveCourse(course);// persist
        if(!isEnrolled)
            throw new Exception("Student already Enrolled");
        return persistedCourse;
    }

    @Override
    public Course assignCourseToTeacher(Integer courseId, Integer teacherId) {
        Course course = getCourseById(courseId);
        Teacher teacher = teacherServiceImpl.getTeacherById(teacherId);
        course.setTeacher(teacher);
       return courseRepository.save(course);
    }

}
