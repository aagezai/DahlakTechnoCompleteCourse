package com.dahlaktechnomicroservicecourseservice.Service.ServiceImpl;


import com.dahlaktechnomicroservicecourseservice.Model.Course;
import com.dahlaktechnomicroservicecourseservice.Exception.ResourceNotFoundException;
import com.dahlaktechnomicroservicecourseservice.Model.Teacher;
import com.dahlaktechnomicroservicecourseservice.Pojo.ACourseWithEnrolledStudents;
import com.dahlaktechnomicroservicecourseservice.Pojo.CourseEnrolledByStudent;
import com.dahlaktechnomicroservicecourseservice.Pojo.Student;
import com.dahlaktechnomicroservicecourseservice.Repository.CourseRepository;
import com.dahlaktechnomicroservicecourseservice.Service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RestTemplate restTemplate;
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
    public Course assignCourseToTeacher(Integer courseId, Integer teacherId) {
        Course course = getCourseById(courseId);
        Teacher teacher = teacherServiceImpl.getTeacherById(teacherId);
        course.setTeacher(teacher);
       return courseRepository.save(course);
    }
/*
 List<Integer> officialIds = null;
  //add values to officialIds 
  RestTemplate restTemplate = new RestTemplate();

  HttpHeaders headers = new HttpHeaders();

  HttpEntity<List<Integer>> request = new HttpEntity<List<Integer>>(officialIds, 
    headers);

  ResponseEntity<YourResponseClass[]> responses = 
  restTemplate.postForEntity("your URL", request , YourResponseClass[].class );

  List<YourResponseClass> list = Arrays.asList(responses.getBody());

*/

    @Override
    public ACourseWithEnrolledStudents getACourseWithEnrolledStudents(Integer courseId) {
        Course course = getCourseById(courseId);
        ACourseWithEnrolledStudents aCourseWithStudents = new ACourseWithEnrolledStudents();
        Set<Student> enrolledStudents =
                course.getStudentsId().stream().map(stuId ->getStudentById(stuId)).collect(Collectors.toSet());

        aCourseWithStudents.setCourse(course);
        aCourseWithStudents.setStudentList(enrolledStudents);
        return aCourseWithStudents;
    }

    @Override
    public CourseEnrolledByStudent enrolledStudent(Integer courseId, Integer studentId) throws Exception {
        Course course = getCourseById(courseId);
        Student student = getStudentById(studentId);
        boolean isEnrolled = course.enrollStudent(studentId);
        Course persistedCourse = saveCourse(course);// persist

        if(!isEnrolled)
            throw new Exception("Student already Enrolled");
        return new CourseEnrolledByStudent(persistedCourse,student);
    }
    private Student getStudentById(Integer studentId) {
        logger.info("getStudentById called response expected Student-Microservice");
          return  restTemplate
                  .getForObject("http://STUDENT-SERVICE/api/students/student/" + studentId,Student.class);



    }

}
