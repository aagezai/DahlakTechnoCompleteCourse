package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.ServiceImpl;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Student;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Repository.StudentRepository;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student) ;
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.findById(studentId).get();
    }
    @Override
    public Student deleteStudentById(Integer studentId) {
        Student student = getStudentById(studentId);
         studentRepository.deleteById(studentId);
         return student;
    }
    @Override
    public Student setPassportToStudent(Student student) {
        return studentRepository.save(student);
    }

}
