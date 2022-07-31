package com.dahlakTechnoMicroserviceStudentService.Controller;

import com.dahlakTechnoMicroserviceStudentService.Model.Student;
import com.dahlakTechnoMicroserviceStudentService.Service.ServiceImpl.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentServiceImpl studentServiceImpl;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }
    @PostMapping("/student")
    public void saveStudent(@RequestBody Student student){
        logger.info("saveStudent called");
         studentServiceImpl.saveStudent(student);

    }
    @DeleteMapping("/student/{studentId}")
    public void  deleteStudentById(@PathVariable Integer studentId){
         studentServiceImpl.deleteStudentById(studentId);
    }
    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable Integer studentId){
        return studentServiceImpl.getStudentById(studentId);
    }
    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return studentServiceImpl.getAllStudents();
    }
    @PutMapping("/student/{studentId}/passport/{passportId}")
    public Student setPassportToStudent(@PathVariable Integer studentId,@PathVariable Integer passportId){

        return studentServiceImpl.setPassportToStudent(studentId,passportId);
    }

}
