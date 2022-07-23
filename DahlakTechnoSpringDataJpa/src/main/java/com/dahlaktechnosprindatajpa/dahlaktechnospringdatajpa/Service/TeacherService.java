package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Teacher;

import java.util.List;

public interface TeacherService {
    public Teacher  saveTeacher(Teacher teacher);
    public Teacher  deleteTeacherById(Integer teacherId);
    public  Teacher getTeacherById(Integer teacherId);
    public List<Teacher> getAllTeacher();
}
