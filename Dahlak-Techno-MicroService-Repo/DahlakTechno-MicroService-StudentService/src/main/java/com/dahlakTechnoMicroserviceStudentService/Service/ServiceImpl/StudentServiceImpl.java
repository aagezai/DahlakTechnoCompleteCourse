package com.dahlakTechnoMicroserviceStudentService.Service.ServiceImpl;


import com.dahlakTechnoMicroserviceStudentService.Exception.ResourceNotFoundException;
import com.dahlakTechnoMicroserviceStudentService.Model.Passport;
import com.dahlakTechnoMicroserviceStudentService.Model.Student;
import com.dahlakTechnoMicroserviceStudentService.Repository.StudentRepository;
import com.dahlakTechnoMicroserviceStudentService.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    private StudentRepository studentRepository;
    @Autowired
    private PassportServiceImpl passportServiceImpl;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student) ;
    }


    @Override
    public Student getStudentById(Integer studentId) {

        return studentRepository.findById(studentId).
                orElseThrow(()->new ResourceNotFoundException("Student","Student Id",studentId));
    }
    @Override
    public Student deleteStudentById(Integer studentId) {
        Student student = getStudentById(studentId);
         studentRepository.deleteById(studentId);
         return student;
    }
    @Override
    public Student setPassportToStudent(Integer studentId, Integer passportId) {
        Student student = getStudentById(studentId);
        Passport passport = passportServiceImpl.getPassportById(passportId);
        student.setPassport(passport);
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}
