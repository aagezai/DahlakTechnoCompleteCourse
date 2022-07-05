package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Controller;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Passport;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Student;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.ServiceImpl.PassportServiceImpl;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.ServiceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentServiceImpl studentServiceImpl;
    @Autowired
    private PassportServiceImpl passportServiceImpl;
    @Autowired
    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }
    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student){
        return studentServiceImpl.saveStudent(student);

    }
    @DeleteMapping("/student/{studentId}")
    public Student deleteStudentById(@PathVariable Integer studentId){
        return studentServiceImpl.deleteStudentById(studentId);
    }
    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable Integer studentId){
        return studentServiceImpl.getStudentById(studentId);
    }
    @PutMapping("/student/{studentId}/passport/{passportId}")
    public Student setPassportToStudent(@PathVariable Integer studentId,@PathVariable Integer passportId){
        Student student = getStudentById(studentId);
        Passport passport = passportServiceImpl.getPassportById(passportId);
        student.setStudentPassport(passport);

        return studentServiceImpl.setPassportToStudent(student);
    }
}