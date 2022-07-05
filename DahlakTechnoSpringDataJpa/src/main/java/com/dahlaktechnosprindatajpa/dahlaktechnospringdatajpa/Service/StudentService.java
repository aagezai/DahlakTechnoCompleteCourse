package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Student;

public interface StudentService {
    public Student saveStudent(Student student);
    public Student deleteStudentById(Integer studentId);
    public Student getStudentById(Integer studentId);
}
