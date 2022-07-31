package com.dahlakTechnoMicroserviceStudentService.Service;


import com.dahlakTechnoMicroserviceStudentService.Model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public Student deleteStudentById(Integer studentId);
    public Student getStudentById(Integer studentId);
    public Student setPassportToStudent(Integer studentId, Integer passportId);
    List<Student> getAllStudents();
}
